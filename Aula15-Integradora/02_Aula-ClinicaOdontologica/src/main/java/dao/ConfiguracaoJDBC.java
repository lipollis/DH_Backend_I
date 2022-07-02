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

    // CRIAÇÃO DAS TABELAS
    private static final String SQL_CREATE_TABLE_PACIENTES = //"DROP TABLE IF EXISTS pacientes; " +
                                                             "CREATE TABLE IF NOT EXISTS pacientes" +
                                                             "(" +
                                                             "id int auto_increment primary key," +
                                                             "nome varchar(255)," +
                                                             "sobrenome varchar(255)," +
                                                             "rg varchar(255)," +
                                                             "dataDeCadastro TIMESTAMP WITHOUT TIME ZONE," +
                                                             "enderecoId int" +
                                                             ");";

    private static final String SQL_CREATE_TABLE_ENDERECOS = //"DROP TABLE IF EXISTS enderecos; " +
                                                             "CREATE TABLE IF NOT EXISTS enderecos" +
                                                             "(" +
                                                             "id int auto_increment primary key," +
                                                             "rua varchar(255)," +
                                                             "numero varchar(255)," +
                                                             "cidade varchar(255)," +
                                                             "estado varchar (255)" +
                                                             ");";

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
            statement.execute(SQL_CREATE_TABLE_PACIENTES);
            statement.execute(SQL_CREATE_TABLE_ENDERECOS);
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
