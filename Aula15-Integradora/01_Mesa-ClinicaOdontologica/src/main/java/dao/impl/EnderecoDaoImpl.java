package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Endereco;
import org.apache.log4j.Logger;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnderecoDaoImpl implements IDao<Endereco> {
    // INSTANCIAR A CONFIGURAÇÃO
    private ConfiguracaoJDBC configuracaoJDBC;
    final static Logger log = Logger.getLogger(EnderecoDaoImpl.class);


    // CONSTRUTOR DO CONFIG JDBC
    public EnderecoDaoImpl(){
        this.configuracaoJDBC = new ConfiguracaoJDBC();
    }

    // IMPLEMENTAÇÃO DOS MÉTODOS
    @Override
    //LÓGICA PARA SALVAR
    public Endereco salvar(Endereco endereco) {
        log.debug("Endereço registrado." + endereco.toString());
        // CONEXÃO COM O BANCO
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("INSERT INTO endereco(rua, numero, cidade, estado) " +
                                     "VALUES('%s','%s','%s','%s')",
                                     endereco.getRua(), endereco.getNumero(), endereco.getCidade(), endereco.getEstado()
                                    //, endereco.getIdPaciente()
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
                endereco.setId(keys.getInt(1)); //endereço que o usuário passou

            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return endereco;
    }

    @Override
    public Endereco atualizar(Endereco endereco) {
        log.debug("Endereço atualizado.");
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("UPDATE endereco set rua = '%s', set numero = '%s'," +
                                     "set cidade = '%s', set estado = '%s' WHERE id = '%s'",
                                     endereco.getRua(), endereco.getNumero(), endereco.getCidade(),
                                     endereco.getEstado(), endereco.getId()
                                    );

        try{
            //TRATAMENTO DE ERRO PARA O ID
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()) //PEGA O 'result' E PULA PARA PRÓXIMA LINHA, next()
                // CHAMA O MÉTODO DE CRIAR O OBJETO
                endereco = criarObjetoEndereco(result);

            verEndereco(connection);
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return endereco;
    }

    @Override
    public Optional<Endereco> buscar(Integer id) {
        log.debug("Buscando...");
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("SELECT * FROM endereco WHERE id = '%s'", id);
        Endereco endereco = null;

        try{
            //TRATAMENTO DE ERRO PARA O ID
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()) //PEGA O 'result' E PULA PARA PRÓXIMA LINHA, next()
                // CHAMA O MÉTODO DE CRIAR O OBJETO
                endereco = criarObjetoEndereco(result);

            verEndereco(connection);
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        // SE O ENDEREÇO FOR DIFERENTE DE NULO, PREENCHER O Optional com 'endereco'
        return endereco != null ? Optional.of(endereco) : Optional.empty();
    }

    @Override
    public List<Endereco> buscarTodos() {
        log.debug("Buscando...");
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("SELECT * FROM endereco");
        List<Endereco> enderecos = new ArrayList<>();// MOSTRA TODOS OS ENDEREÇOS

        try{
            //TRATAMENTO DE ERRO PARA O ID
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next())
                // CHAMA O MÉTODO DE CRIAR O OBJETO E ADD NA LISTA
                enderecos.add(criarObjetoEndereco(result));

            verEndereco(connection);
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return enderecos;
    }

    @Override
    public void excluir(Integer id) {
        log.debug("Endereço deletado.");
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("DELETE FROM endereco WHERE id = '%s'", id);

        try{
            //TRATAMENTO DE ERRO PARA O ID
            statement = connection.createStatement();
            statement.executeUpdate(query);

            verEndereco(connection);
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // MÉTODO QUE PEGA O QUE CHEGA DO RESULTADO E O ENTREGA COMO OBJETO
    private Endereco criarObjetoEndereco(ResultSet result) throws SQLException {
        //throws retorna o erro de caso o id não ter sido preenchido antes
        Integer id = result.getInt("id");
        String rua = result.getString("rua");
        String numero = result.getString("numero");
        String cidade = result.getString("cidade");
        String estado = result.getString("estado");
        //Integer idPaciente = result.getInt("idPaciente");

        return new Endereco(id, rua, numero, cidade, estado); // USA O CONSTRUTOR QUE USA O ID
    }

    // MÉTODO QUE EXIBE NA TELA AS ALTERAÇÕES REALIZADAS NO BANCO
    private static void verEndereco(Connection connection) throws SQLException {
        String sql = "SELECT * FROM endereco";
        Statement sqlSmt = connection.createStatement();
        ResultSet rsEnd = sqlSmt.executeQuery(sql);
        System.out.println("\n--------------------  QUERY ENDEREÇO --------------------");

        while(rsEnd.next()) {
            PrintStream varEndereco = System.out;
            int varEnd = rsEnd.getInt(1);
            varEndereco.println(varEnd + " " + rsEnd.getString(2) + " " + rsEnd.getString(3)
                             + " " + rsEnd.getString(4) + " " + rsEnd.getString(5)
                             //+ " " + rsEnd.getString(6)
                               );
        }

        System.out.println("-----------------------------------------------------------");
    }
}
