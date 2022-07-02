package com.example.clinicaOdonto.model;

import lombok.Getter;
import lombok.Setter;

// ANOTAÇÕES LOMBOOK
@Getter
@Setter
public class Dentista {
    // ATRIBUTOS
    private Integer id;
    private Integer matricula;
    private String nome;
    private String sobrenome;

    // toString
    @Override
    public String toString() {
        return "Dentista{" + " id= " + id + " - " + matricula + " || " + nome + '\'' + " " + sobrenome + "}";
    }
}
