import org.apache.log4j.Logger; //IMPORT DA BIBLIOTECA EXTERNA. NÃO ESQUECER DE ADD.
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
// src>new>Resource bundle> colar script com nome log4j

import java.sql.*;

public class Main {
    // CRIAÇÃO DA TABELA
    private static final String CREATE_TABLE = "DROP TABLE IF EXISTS FUNCIONARIO;" +
            "CREATE TABLE FUNCIONARIO(" +
            "ID INT PRIMARY KEY, " +
            "NOME varchar(100) NOT NULL," +
            "SOBRENOME varchar(100) NOT NULL," +
            "SETOR varchar(50) NOT NULL," +
            "EMAIL varchar(50) NOT NULL)";

    // INSERINDO OS DADOS NA TABELA
    private static final String sqlInsert1 = "INSERT INTO FUNCIONARIO(ID, NOME, SOBRENOME, SETOR, EMAIL) " +
            "VALUES (1, 'Aline', 'Pollis','Engenharia','aline@mail.com')";
    private static final String sqlInsert2 = "INSERT INTO FUNCIONARIO(ID, NOME, SOBRENOME, SETOR, EMAIL) " +
            "VALUES (2, 'Mariana', 'Saidfuss','Administração','mariana@mail.com')";
    private static final String sqlInsert3 = "INSERT INTO FUNCIONARIO(ID, NOME, SOBRENOME, SETOR, EMAIL) " +
            "VALUES (2, 'Bernardo', 'Pence','TI','bernardo@mail.com')";
    private static final String sqlInsert4 = "INSERT INTO FUNCIONARIO(ID, NOME, SOBRENOME, SETOR, EMAIL) " +
            "VALUES (3, 'Guilherme', 'Formenton','TI','bernardo@mail.com')";

    // UPDATE DE DADOS
    private static final String UPDATE = "UPDATE FUNCIONARIO SET ID=4 WHERE NOME='Bernardo'";

    // DELETAR DADOS
    private static final String DELETE_1 = "DELETE FROM FUNCIONARIO WHERE ID=1";
    private static final String DELETE_2 = "DELETE FROM FUNCIONARIO WHERE NOME='Guilherme'";


    //
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception{
        // LÓGICA
        Connection connection = null;

            try {
                connection = getConnection();
                Statement statement = connection.createStatement();
                // EXECUTAR QUERY DE CRIAR TABELA
                statement.execute(CREATE_TABLE);
                // PREENCHER A TABELA
                statement.execute(sqlInsert1);
                statement.execute(sqlInsert2);
                statement.execute(sqlInsert3);
                statement.execute(sqlInsert4);

                verFuncionario(connection); // exibir infos

            } catch (Exception e) {
                logger.info("\n\nID com valor repetido. Unique index or primary key violation\n");

            } try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            // EXECUTAR A QUERY DE UPDATE
            statement.execute(UPDATE);
            logger.debug("\nAtualização do funcionário " + sqlInsert3);
            logger.info("\nAtualização do funcionário " + sqlInsert3);
            // EXECUTAR A QUERY DE DELETE
            statement.execute(DELETE_1);
            logger.info("\nFuncionário desligado " + sqlInsert1);
            statement.execute(DELETE_2);
            logger.info("\nFuncionário desligado " + sqlInsert4);

            verFuncionario(connection); // exibir infos
        }catch (Exception e){

        } finally {
                if (connection == null)
                    return;

                connection.close();
            }
    }

    // CRIAR O MÉTODO DE CONEXÃO EXTERNA
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa","");
    }

    // FUNÇÃO PARA EXIBIR AS ATUALIZAÇÕES DA TABELA
    private static void verFuncionario(Connection connection) throws SQLException {
        String sql = "SELECT * FROM FUNCIONARIO";
        Statement sqlSmt = connection.createStatement();
        ResultSet rs = sqlSmt.executeQuery(sql);
        System.out.println("\n-----------------  QUERY FUNCIONÁRIO ----------------- ");
        while(rs.next()){
            System.out.println(rs.getInt(1) + " " + rs.getString(2)
                               + " " + rs.getString(3)+ " " + rs.getString(4));
        }
        System.out.println("-------------------------------------------------------");
    }

}
