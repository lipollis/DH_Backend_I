package com.example.clinica.model;

public class Dentista {
    // ATRIBUTOS
    private Integer id;
    private Integer matricula;
    private String nome;
    private String sobrenome;

    // CONSTRUTOR
    public Dentista(Integer id, Integer matricula, String nome, String sobrenome) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }


    // GETTER & SETTER
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
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


    // toString
    @Override
    public String toString() {
        return "\nDentista{" +
               "id=" + id +
               ", matricula= " + matricula +
               "\n " + nome +
               " " + sobrenome +
               "}";
    }
}
