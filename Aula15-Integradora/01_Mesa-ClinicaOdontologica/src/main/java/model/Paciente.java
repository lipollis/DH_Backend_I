package model;

import java.util.Date;

public class Paciente {
    // ATRIBUTOS
    private Integer id;
    private String nome;
    private String sobrenome;
    private String rg;
    private Date cadastro;
    private Endereco endereco;

    // CONSTRUTOR
    // SEM O ID PARA QUE CASO PRECISE SER CRIADO A TAB SEM O ID DEFINIDO AINDA
    public Paciente(String nome, String sobrenome, String rg, Date cadastro, Endereco endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cadastro = cadastro;
        this.endereco = endereco;
    }

    public Paciente(
            Integer id, String nome, String sobrenome, String rg, Date cadastro, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cadastro = cadastro;
        this.endereco = endereco;
    }

    // GETTER & SETTER
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    // toString
    @Override
    public String toString() {
        return "\nPaciente{" +
               "\nidPaciente=" + id +
               " -- " + nome + '\'' +
               " " + sobrenome + '\'' +
               "\nrg: " + rg + '\'' +
               " - data de cadastro: " + cadastro +
               "\n " + endereco +
               "\n}";
    }
}
