package com.example.clinicaOdonto.dto;

import com.example.clinicaOdonto.model.Paciente;
import lombok.Getter;
import lombok.Setter;

// OBJETO SALVO NO BANCO

// ASSINATURA LOMBOK
@Getter
@Setter
public class PacienteDTO {
    // ATRIBUTOS
    private Integer id;
    private String nome;
    private String sobrenome;
    private Integer idEndereco; // CHAVE ESTRANGEIRA DO BANCO

    // CONSTRUTOR VAZIO
    public PacienteDTO () {}

    // CONSTRUTOR PARA A CONVERSÃO PACIENTE EM DTO
    public PacienteDTO(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.idEndereco = paciente.getEndereco().getId(); //para prrencher o id recebido de endereço
    }
}
