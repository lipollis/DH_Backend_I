package com.example.clinicaOdonto.dto;

import com.example.clinicaOdonto.model.Dentista;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DentistaDTO {
    private Integer id;
    private Integer numMatricula;
    private String nome;
    private String sobrenome;

    public DentistaDTO(Dentista dentista) {
        this.id = dentista.getId();
        this.numMatricula = dentista.getNumMatricula();
        this.nome = dentista.getNome();
        this.sobrenome = dentista.getSobrenome();
    }
}
