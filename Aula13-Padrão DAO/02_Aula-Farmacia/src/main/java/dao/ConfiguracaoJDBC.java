package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConfiguracaoJDBC {
    // CONFIGURAÇÃO DO H2
    //
    private String jdbcDriver;
    private String dbUrl;
    private String nomeUsuario;
    private String senha;

    // CRIAÇÃO DA TABELA
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS MEDICAMENTOS; CREATE TABLE MEDICAMENTOS " +
                                                   "(" +
                                                   "id int auto_increment primary key, " +
                                                   "codigoNumerico int, " +
                                                   "nome varchar(255), " +
                                                   "laboratorio varchar(255), " +
                                                   "quantidade int, " +
                                                   "preco double)";

    // MÉTODO CONFIG CONSTRUTOR
    public ConfiguracaoJDBC(String jdbcDriver, String dbUrl, String nomeUsuario, String senha) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    // CONSTRUTOR PARA CONEXÃO
    public ConfiguracaoJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/test";
        this.nomeUsuario = "sa";
        this.senha = "";

        criarTabela();
    }

    // CRIAÇÃO DA TABELA
    private void criarTabela(){
        try{
            Connection connection = conectarBanco();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // MÉTODO PARA CONECTAR BANCO (LOCAL)
    public Connection conectarBanco(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(dbUrl, nomeUsuario, senha);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

}
