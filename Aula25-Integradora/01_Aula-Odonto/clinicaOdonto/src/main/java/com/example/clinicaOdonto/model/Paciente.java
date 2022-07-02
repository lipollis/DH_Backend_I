package com.example.clinicaOdonto.model;

import com.example.clinicaOdonto.dto.PacienteDTO;
import lombok.Getter;
import lombok.Setter;

// ASSINATURA LOMBOK
@Getter
@Setter
public class Paciente {
    // ATRIBUTOS
    private Integer id;
    private String nome;
    private String sobrenome;
    private Endereco endereco;

    // CONSTRUTOR VAZIO - PARA QUANDO SOBREESCREVER
    public Paciente(){}

    // CONSTRUTOR PARA A CONVERSÃO DTO EM PACIENTE
    public Paciente(PacienteDTO pacienteDTO, Endereco endereco) {
        this.id = pacienteDTO.getId();
        this.nome = pacienteDTO.getNome();
        this.sobrenome = pacienteDTO.getSobrenome();
        this.endereco = endereco;
    }
}
