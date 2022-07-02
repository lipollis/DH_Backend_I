package com.example.clinicaOdonto.model;

import lombok.Getter;
import lombok.Setter;

// ANOTAÇÕES LOMBOOK
@Getter
@Setter
public class Endereco {
    // ATRIBUTOS
    private Integer id;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;

}
