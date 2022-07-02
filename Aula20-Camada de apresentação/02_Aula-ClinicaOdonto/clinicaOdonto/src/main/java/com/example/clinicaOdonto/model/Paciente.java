package com.example.clinicaOdonto.model;

import lombok.Getter;
import lombok.Setter;

// ANOTAÇÕES LOMBOOK
@Getter
@Setter
public class Paciente {
    // ATRIBUTOS
    private String nome;
    private String sobrenome;
    private String email;
    private Integer idade;

    // CONSTRUTOR
    public Paciente(String nome, String sobrenome, String email, Integer idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.idade = idade;
    }

    // toString

    @Override
    public String toString() {
        return "Paciente" +
               "\n{ " + nome +
               " " + sobrenome +
               " - email='" + email +
               " - idade: " + idade +
               '}';
    }
}
