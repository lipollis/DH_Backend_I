package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConfiguracaoJDBC {
    // CONFIGURAÇÃO DO H2
    private String jdbcDriver;
    private String dbUrl;
    private String nomeUsuario;
    private String senha;

    // CRIAÇÃO DA TABELA
    private static final String SQL_CREATE_TABLE_ENDERECO = "DROP TABLE IF EXISTS PACIENTE; CREATE TABLE PACIENTE " +
                                                            "(" +
                                                            "idEnd int auto_increment PRIMARY KEY, " +
                                                            "rua varchar(150), " +
                                                            "sobrenome varchar(50), " +
                                                            "rg varchar(15), " +
                                                            "dataCadastro date, " +
                                                            "idEnd int," +
                                                            ")";

    private static final String SQL_CREATE_TABLE_PACIENTE = "DROP TABLE IF EXISTS PACIENTE; CREATE TABLE PACIENTE " +
                                                   "(" +
                                                   "idPac int auto_increment PRIMARY KEY, " +
                                                   "nome varchar(50), " +
                                                   "sobrenome varchar(50), " +
                                                   "rg varchar(15), " +
                                                   "dataCadastro date, " +
                                                   "idEnd int," +
                                                   "FOREIGN KEY (idEnd) REFERENCES endereco (idEnd)" +
                                                    ")";


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
