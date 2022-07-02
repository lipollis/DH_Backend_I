package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConfiguracaoJDBC {
    // CONFIGURAÇÃO DO H2
    private String jdbcDriver;
    private String dbUrl;
    private String usuario;
    private String senha;

    // CRIAÇÃO DA TABELA
    private static final String SQL_CREATE_TABLE_DENTISTA = "DROP TABLE IF EXISTS dentista; " +
                                                            "CREATE TABLE dentista " +
                                                            "(" +
                                                            "id int auto_increment PRIMARY KEY, " +
                                                            "matricula varchar(15), " +
                                                            "nome varchar(50), " +
                                                            "sobrenome varchar(50) " +
                                                            ")";

    // MÉTODO CONFIG CONSTRUTOR
    public ConfiguracaoJDBC(String jdbcDriver, String dbUrl, String nomeUsuario, String senha) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.usuario = usuario;
        this.senha = senha;
    }

    // CONSTRUTOR PARA CONEXÃO
    public ConfiguracaoJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/test";
        this.usuario = "sa";
        this.senha = "";

        criarTabela();
    }

    // CRIAÇÃO DA TABELA
    private void criarTabela(){
        try{
            Connection connection = conectarBanco();
            Statement statement = connection.createStatement(); //ENVIA O SQL PARA A BASE, CONEXÃO
            statement.execute(SQL_CREATE_TABLE_DENTISTA);
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // MÉTODO PARA CONECTAR BANCO (LOCAL)
    public Connection conectarBanco(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(dbUrl, usuario, senha);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
