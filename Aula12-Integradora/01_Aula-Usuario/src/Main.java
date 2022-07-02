import org.apache.log4j.Logger; //IMPORT DA BIBLIOTECA EXTERNA. NÃO ESQUECER DE ADD.
// src>new>Resource bundle> colar script com nome log4j

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

    // CRIAÇÃO DA TABELA
    private static final String CREATE_TABLE = "DROP TABLE IF EXISTS USUARIO;" +
            "CREATE TABLE USUARIO(" +
            "ID INT PRIMARY KEY, " +
            "PRIMEIRO_NOME varchar(100) NOT NULL," +
            "SOBRENOME varchar(100) NOT NULL, " +
            "IDADE INT NOT NULL)";


    // INSERINDO OS DADOS NA TABELA
    private static final String sqlInsert1 = "INSERT INTO USUARIO(ID, PRIMEIRO_NOME, SOBRENOME, IDADE) VALUES (1, 'Aline', 'Pollis',36)";
    private static final String sqlInsert2 = "INSERT INTO USUARIO(ID, PRIMEIRO_NOME, SOBRENOME, IDADE) VALUES (2, 'Mariana', 'Saidfuss',5)";
    private static final String sqlInsert3 = "INSERT INTO USUARIO(ID, PRIMEIRO_NOME, SOBRENOME, IDADE) VALUES (3, 'Bernardo', 'Saidfuss',2)";

    // DELETAR DADO
    private static final String Delete = "DELETE FROM USUARIO WHERE ID=1";

    //
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception{
        // LÓGICA
        Connection connection = null;

        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            // EXECUTAR QUERY DE CRIAR TABELA
            statement.execute(CREATE_TABLE);
            // PREENCHER A TABELA
            statement.execute(sqlInsert1);
            statement.execute(sqlInsert2);
            statement.execute(sqlInsert3);
            // DELETAR
            statement.execute(Delete);
            logger.info("Excluindo o usuário com o ID 1");
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(connection == null)
                return;

            connection.close();
        }

    }

    // CRIAR O MÉTODO DE CONEXÃO EXTERNA
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa","");
    }
}
