package dao.impl;


import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Endereco;
import model.Paciente;
import org.apache.log4j.Logger;
import util.Util;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public class PacienteDaoImpl implements IDao<Paciente> {
    // INSTANCIAR A CONFIGURAÇÃO
    private ConfiguracaoJDBC configuracaoJDBC;
    private EnderecoDaoImpl enderecoDao;
    final static Logger log = Logger.getLogger(PacienteDaoImpl.class);

    // CONSTRUTOR DO CONFIG JDBC
    public PacienteDaoImpl(){
        this.configuracaoJDBC = new ConfiguracaoJDBC();
        this.enderecoDao = new EnderecoDaoImpl();
    }

    // IMPLEMENTAÇÃO DOS MÉTODOS
    @Override
    public Paciente salvar(Paciente paciente) {
        log.debug("Endereço registrado. " + paciente.toString());
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;
        paciente. setEndereco(enderecoDao.salvar(paciente.getEndereco()));

        String query = String.format("INSERT INTO paciente(nome, sobrenome, rg, cadastro, idEndereco) " +
                                     "VALUES('%s','%s','%s','%s','%s')",
                                     paciente.getNome(), paciente.getSobrenome(), paciente.getRg(),
                                     Util.dateToTimestamp(paciente.getCadastro()), paciente.getEndereco().getId()
                                    );

        try{
            //TRATAMENTO DE ERRO PARA O ID
            statement = connection.createStatement();
            // RETORNA TODA A INFORMAÇÃO PARA O USUÁRIO - EXECUTA E FAZ UPDATE
            // COMO SE CONSTRUISSE UMA NOVA QUERY PARA MOSTRAR O RETORNO DA CHAVE APÓS O INSERT,
            // POIS O INSERT NÃO DÁ RETORNO. FUNCIONA COMO UM SELECT
            statement.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
            // FORMATO QUE PEGA O RETORNO DA CHAVE GERADA DO STATEMENT
            ResultSet keys = statement.getGeneratedKeys();

            if (keys.next())
                paciente.setId(keys.getInt(1)); //endereço que o usuário passou

            verPaciente(connection);
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        log.debug("Paciente atualizado. ");
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("UPDATE paciente set nome = '%s', set sobrenome = '%s'," +
                                     "set rg = '%s', set cadastro = '%s' WHERE id = '%s'",
                                     paciente.getNome(), paciente.getSobrenome(), paciente.getRg(),
                                     Util.dateToTimestamp(paciente.getCadastro()), paciente.getId()
                                    );

        try{
            //TRATAMENTO DE ERRO PARA O ID
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()) //PEGA O 'result' E PULA PARA PRÓXIMA LINHA, next()
                // CHAMA O MÉTODO DE CRIAR O OBJETO
                paciente = criarObjetoPaciente(result);

            verPaciente(connection);
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Optional<Paciente> buscar(Integer id) {
        log.debug("Buscando...");
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("SELECT * FROM paciente WHERE id = '%s'", id);
        Paciente paciente = null;

        try{
            //TRATAMENTO DE ERRO PARA O ID
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()) //PEGA O 'result' E PULA PARA PRÓXIMA LINHA, next()
                // CHAMA O MÉTODO DE CRIAR O OBJETO
                paciente = criarObjetoPaciente(result);

            verPaciente(connection);
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        // SE O ENDEREÇO FOR DIFERENTE DE NULO, PREENCHER O Optional com 'endereco'
        return paciente != null ? Optional.of(paciente) : Optional.empty();
    }

    @Override
    public List<Paciente> buscarTodos() {
        log.debug("Buscando...");
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("SELECT * FROM paciente");
        List<Paciente> pacientes = new ArrayList<>();// MOSTRA TODOS OS PACIENTES

        try{
            //TRATAMENTO DE ERRO PARA O ID
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next())
                // CHAMA O MÉTODO DE CRIAR O OBJETO E ADD NA LISTA
                pacientes.add(criarObjetoPaciente(result));

            verPaciente(connection);
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return pacientes;
    }

    @Override
    public void excluir(Integer id) {
        log.debug("Paciente deletado. ");
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;
        // FAZ UMA BUSCA EM PACIENTE ANTES DE EXCLUIR PARA CONSEGUIR O ID DO ENDERECO
        Paciente paciente = buscar(id).get();
        String query = String.format("DELETE FROM paciente WHERE id = '%s'", id);

        try{
            //TRATAMENTO DE ERRO PARA O ID
            statement = connection.createStatement();
            statement.executeUpdate(query);
            // APÓS A BUSCA TEM O ID DO ENDEREÇO E JÁ CONSEGUE EXCLUIR OS DADOS DAS DUAS TABELAS
            enderecoDao.excluir(paciente.getEndereco().getId());
            verPaciente(connection);
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // MÉTODO QUE PEGA O QUE CHEGA DO RESULTADO E O ENTREGA COMO OBJETO
    private Paciente criarObjetoPaciente(ResultSet result) throws SQLException {
        //throws retorna o erro de caso o id não ter sido preenchido antes
        Integer id = result.getInt("id");
        String nome = result.getString("nome");
        String sobrenome = result.getString("sobrenome");
        String rg = result.getString("rg");
        Date cadastro = result.getDate("cadastro");
        Endereco endereco = enderecoDao.buscar(result.getInt("idEndereco")).orElse(null);

        return new Paciente(id, nome, sobrenome, rg, cadastro, endereco); // USA O CONSTRUTOR QUE USA O ID
    }

    // MÉTODO QUE EXIBE NA TELA AS ALTERAÇÕES REALIZADAS NO BANCO
    private static void verPaciente(Connection connection) throws SQLException {
        String sql = "SELECT * FROM paciente";
        Statement sqlSmt = connection.createStatement();
        ResultSet rsPac = sqlSmt.executeQuery(sql);
        System.out.println("\n--------------------  QUERY ENDEREÇO --------------------");

        while(rsPac.next()) {
            PrintStream varPaciente = System.out;
            int varPac = rsPac.getInt(1);
            varPaciente.println(varPac + " " + rsPac.getString(2) + " " + rsPac.getString(3)
                                + " " + rsPac.getString(4) + " " + rsPac.getDate(5)
                                + " " + rsPac.getString(6));
        }

        System.out.println("-----------------------------------------------------------");
    }


}
