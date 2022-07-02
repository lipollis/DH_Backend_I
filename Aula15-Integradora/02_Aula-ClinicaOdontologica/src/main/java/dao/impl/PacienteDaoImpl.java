package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Endereco;
import model.Paciente;
import util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

// IMPLEMENTAÇÃO DOS MÉTODOS
public class PacienteDaoImpl implements IDao<Paciente> {
    // INSTANCIAR A CONFIGURAÇÃO
    private ConfiguracaoJDBC configuracaoJDBC;
    private EnderecoDaoImpl enderecoDao;

    // CONSTRUTOR DO CONFIG JDBC
    public PacienteDaoImpl(){
        this.configuracaoJDBC = new ConfiguracaoJDBC();
        this.enderecoDao = new EnderecoDaoImpl();

    }
    @Override
    public Paciente salvar(Paciente paciente) {
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;
        paciente. setEndereco(enderecoDao.salvar(paciente.getEndereco()));

        String query = String.format("INSERT INTO pacientes(nome, sobrenome, rg, dataDeCadastro, enderecoId) " +
                                     "VALUES('%s','%s','%s','%s','%s')",
                                     paciente.getNome(), paciente.getSobrenome(), paciente.getRg(),
                                     Util.dateToTimestamp(paciente.getDataDeCadastro()), paciente.getEndereco().getId()
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

            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Optional<Paciente> buscar(Integer id) {
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("SELECT * FROM pacientes where id = '%s'", id);
        Paciente paciente = null;

        try{
            //TRATAMENTO DE ERRO PARA O ID
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()) //PEGA O 'result' E PULA PARA PRÓXIMA LINHA, next()
                // CHAMA O MÉTODO DE CRIAR O OBJETO
                paciente = criarObjetoPaciente(result);

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
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("SELECT * FROM pacientes");
        List<Paciente> pacientes = new ArrayList<>();// MOSTRA TODOS OS PACIENTES

        try{
            //TRATAMENTO DE ERRO PARA O ID
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next())
                // CHAMA O MÉTODO DE CRIAR O OBJETO E ADD NA LISTA
                pacientes.add(criarObjetoPaciente(result));

            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return pacientes;
    }

    @Override
    public void excluir(Integer id) {
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;
        // FAZ UMA BUSCA EM PACIENTE ANTES DE EXCLUIR PARA CONSEGUIR O ID DO ENDERECO
        Paciente paciente = buscar(id).get();
        String query = String.format("DELETE FROM pacientes WHERE id = '%s'", id);

        try{
            //TRATAMENTO DE ERRO PARA O ID
            statement = connection.createStatement();
            statement.executeUpdate(query);
            // APÓS A BUSCA TEM O ID DO ENDEREÇO E JÁ CONSEGUE EXCLUIR OS DADOS DAS DUAS TABELAS
            enderecoDao.excluir(paciente.getEndereco().getId());
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Paciente alterar(Paciente paciente) {
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("UPDATE pacientes set nome = '%s',set sobrenome = '%s'," +
                                     "set rg = '%s',set dataDeCadastro = '%s' WHERE id = '%s'",
                                     paciente.getNome(), paciente.getSobrenome(), paciente.getRg(),
                                     Util.dateToTimestamp(paciente.getDataDeCadastro()), paciente.getId()
                                    );

        try{
            //TRATAMENTO DE ERRO PARA O ID
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()) //PEGA O 'result' E PULA PARA PRÓXIMA LINHA, next()
                // CHAMA O MÉTODO DE CRIAR O OBJETO
                paciente = criarObjetoPaciente(result);

            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return paciente;
    }

    // MÉTODO QUE PEGA O QUE CHEGA DO RESULTADO E O ENTREGA COMO OBJETO
    private Paciente criarObjetoPaciente(ResultSet result) throws SQLException {
        //throws retorna o erro de caso o id não ter sido preenchido antes
        Integer idPaciente = result.getInt("id");
        String nome = result.getString("nome");
        String sobrenome = result.getString("sobrenome");
        String rg = result.getString("rg");
        Date dataDeCadastro = result.getDate("dataDeCadastro");
        Endereco endereco = enderecoDao.buscar(result.getInt("enderecoId")).orElse(null);

        return new Paciente(idPaciente, nome, sobrenome, rg, dataDeCadastro, endereco); // USA O CONSTRUTOR QUE USA O ID
    }
}
