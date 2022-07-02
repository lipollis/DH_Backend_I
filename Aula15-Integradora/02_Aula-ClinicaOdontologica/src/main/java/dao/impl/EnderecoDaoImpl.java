package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Endereco;

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


    // CONSTRUTOR DO CONFIG JDBC
    public EnderecoDaoImpl(){
        this.configuracaoJDBC = new ConfiguracaoJDBC();
    }

    // IMPLEMENTAÇÃO DOS MÉTODOS
    @Override
    //LÓGICA PARA SALVAR
    public Endereco salvar(Endereco endereco) {
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("INSERT INTO enderecos(rua,numero,cidade,estado) " +
                                     "VALUES('%s','%s','%s','%s')",
                                     endereco.getRua(), endereco.getNumero(), endereco.getCidade(), endereco.getEstado()
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
    public Optional<Endereco> buscar(Integer id) {
            Connection connection = configuracaoJDBC.conectarBanco();
            Statement statement = null;

            String query = String.format("SELECT * FROM enderecos where id = '%s'", id);
            Endereco endereco = null;

            try{
                //TRATAMENTO DE ERRO PARA O ID
                statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                while(result.next()) //PEGA O 'result' E PULA PARA PRÓXIMA LINHA, next()
                    // CHAMA O MÉTODO DE CRIAR O OBJETO
                    endereco = criarObjetoEndereco(result);

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
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("SELECT * FROM enderecos");
        List<Endereco> enderecos = new ArrayList<>();// MOSTRA TODOS OS ENDEREÇOS

        try{
            //TRATAMENTO DE ERRO PARA O ID
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next())
                // CHAMA O MÉTODO DE CRIAR O OBJETO E ADD NA LISTA
                enderecos.add(criarObjetoEndereco(result));

            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return enderecos;
    }

    @Override
    public void excluir(Integer id) {
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("DELETE FROM enderecos WHERE id = '%s'", id);

        try{
            //TRATAMENTO DE ERRO PARA O ID
            statement = connection.createStatement();
            statement.executeUpdate(query);

            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Endereco alterar(Endereco endereco) {
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("UPDATE enderecos set rua = '%s',set numero = '%s'," +
                                     "set cidade = '%s',set estado = '%s' WHERE id = '%s'",
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

            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return endereco;
    }

    // MÉTODO QUE PEGA O QUE CHEGA DO RESULTADO E O ENTREGA COMO OBJETO
    private Endereco criarObjetoEndereco(ResultSet result) throws SQLException {
        //throws retorna o erro de caso o id não ter sido preenchido antes
        Integer id = result.getInt("id");
        String rua = result.getString("rua");
        String numero = result.getString("numero");
        String cidade = result.getString("cidade");
        String estado = result.getString("estado");

        return new Endereco(id, rua, numero, cidade, estado); // USA O CONSTRUTOR QUE USA O ID
    }
}
