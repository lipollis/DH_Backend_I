package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Dentista;
import org.apache.log4j.Logger;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DentistaDaoImpl implements IDao<Dentista> {
    // INSTANCIAR A CONFIGURAÇÃO
    private ConfiguracaoJDBC configuracaoJDBC;
    final static Logger log = Logger.getLogger(DentistaDaoImpl.class);

    // CONSTRUTOR DO CONFIG JDBC
    public DentistaDaoImpl(){
        this.configuracaoJDBC = new ConfiguracaoJDBC();
    }

    // IMPLEMENTAÇÃO DOS MÉTODOS
    @Override
    //LÓGICA PARA SALVAR
    public Dentista salvar(Dentista dentista) {
        log.debug("Registro realizado.");
        // CONEXÃO COM O BANCO
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("INSERT INTO dentista(matricula,nome,sobrenome) " +
                                     "VALUES('%s','%s','%s')",
                                     dentista.getMatricula(), dentista.getNome(), dentista.getSobrenome()
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
                dentista.setIdDentista(keys.getInt(1));

            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return dentista;
    }

    @Override
    public Dentista atualizar(Dentista dentista) {
        log.debug("Registro atualizado.");
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("UPDATE dentista set matricula = '%s',set nome = '%s'," +
                                     "set sobrenome = '%s' WHERE id = '%s'",
                                     dentista.getMatricula(), dentista.getNome(), dentista.getSobrenome(),
                                     dentista.getIdDentista()
                                    );

        try{
            //TRATAMENTO DE ERRO
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()) //PEGA O 'result' E PULA PARA PRÓXIMA LINHA, next()
                // CHAMA O MÉTODO DE CRIAR O OBJETO
                dentista = criarObjetoDentista(result);

            verDentista(connection);
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return dentista;
    }

    @Override
    public Optional<Dentista> buscar(Integer idDentista) {
        log.debug("Buscando...");Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("SELECT * FROM dentista where id = '%s'", idDentista);
        Dentista dentista = null;

        try{
            //TRATAMENTO DE ERRO PARA O ID
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()) //PEGA O 'result' E PULA PARA PRÓXIMA LINHA, next()
                // CHAMA O MÉTODO DE CRIAR O OBJETO
                dentista = criarObjetoDentista(result);

            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        // SE O DENTISTA FOR DIFERENTE DE NULO, PREENCHER O Optional com 'dentista'
        return dentista != null ? Optional.of(dentista) : Optional.empty();
    }

    @Override
    public List<Dentista> buscarTodos() {
        log.debug("Buscando...");
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("SELECT * FROM dentista");
        List<Dentista> dentistas = new ArrayList<>();// MOSTRA TODOS OS ENDEREÇOS

        try{
            //TRATAMENTO DE ERRO PARA O ID
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next())
                // CHAMA O MÉTODO DE CRIAR O OBJETO E ADD NA LISTA
                dentistas.add(criarObjetoDentista(result));

            verDentista(connection);
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return dentistas;
    }

    @Override
    public void excluir(Integer idDentista) {
        log.debug("O registro foi excluído.");
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("DELETE FROM dentista WHERE id = '%s'", idDentista);

        try{
            //TRATAMENTO DE ERRO
            statement = connection.createStatement();
            statement.executeUpdate(query);

            verDentista(connection);
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // MÉTODO QUE PEGA O QUE CHEGA DO RESULTADO E O ENTREGA COMO OBJETO
    private Dentista criarObjetoDentista(ResultSet result) throws SQLException {
        //throws retorna o erro de caso o id não ter sido preenchido antes
        Integer idDentista = result.getInt("id");
        Integer matricula = result.getInt("matricula");
        String nome = result.getString("nome");
        String sobrenome = result.getString("sobrenome");

        return new Dentista(idDentista, matricula, nome, sobrenome); // USA O CONSTRUTOR QUE USA O ID
    }

    // MÉTODO QUE EXIBE NA TELA AS ALTERAÇÕES REALIZADAS NO BANCO
    private static void verDentista(Connection connection) throws SQLException {
        String sql = "SELECT * FROM dentista";
        Statement sqlSmt = connection.createStatement();
        ResultSet rs = sqlSmt.executeQuery(sql);
        System.out.println("\n--------------------  QUERY DENTISTA --------------------");

        while(rs.next()) {
            PrintStream var10000 = System.out;
            int var10001 = rs.getInt(1);
            var10000.println(var10001 + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
        }

        System.out.println("-----------------------------------------------------------");
    }
}
