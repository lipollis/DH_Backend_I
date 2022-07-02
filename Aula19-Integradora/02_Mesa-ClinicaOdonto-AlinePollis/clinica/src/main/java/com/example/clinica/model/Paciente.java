package com.example.clinica.model;

import java.time.LocalDate;

public class Paciente {
    // ATRIBUTOS
    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
    private LocalDate cadastro;
    private Endereco endereco;
    private Dentista dentista;

    // CONSTRUTOR
    public Paciente(
            Integer id, String nome, String sobrenome, String email, String cpf, LocalDate cadastro,
            Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf = cpf;
        this.cadastro = cadastro;
        this.endereco = endereco;
    }

    public Paciente(
            Integer id, String nome, String sobrenome, String email, String cpf, LocalDate cadastro,
            Endereco endereco, Dentista dentista) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf = cpf;
        this.cadastro = cadastro;
        this.endereco = endereco;
        this.dentista = dentista;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getCadastro() {
        return cadastro;
    }

    public void setCadastro(LocalDate cadastro) {
        this.cadastro = cadastro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    // toString
    @Override
    public String toString() {
        return "Paciente{" +
               "\nid=" + id + " - " + nome + " " + sobrenome +
               "\nemail='" + email + " - CPF: " + cpf + " - Data de Cadastro: " + cadastro +
               "\nEndereco: " + endereco +
               "\nDentista: " + dentista +
               "\n}";
    }
}
