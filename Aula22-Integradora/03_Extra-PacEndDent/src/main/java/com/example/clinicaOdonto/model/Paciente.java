package com.example.clinicaOdonto.model;

import lombok.Getter;
import lombok.Setter;

// ANOTAÇÕES LOMBOOK
@Getter
@Setter
public class Paciente {
    // ATRIBUTOS
    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private Integer idade;
    private Endereco endereco;
    private Integer idEndereco;

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
