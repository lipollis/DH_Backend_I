package com.example.clinicaOdonto.model;

import com.example.clinicaOdonto.dto.ConsultaDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// ASSINATURA DO LOMBOOK
@Getter
@Setter
public class Consulta {
    // ATRIBUTOS
    private Integer id;
    private Paciente paciente;
    private Dentista dentista;
    private Date dataHora;

    // MÉTODO CONSTRUTOR PARA CONVERSÃO
    public Consulta(ConsultaDTO consultaDTO, Paciente paciente, Dentista dentista) {
        this.id = consultaDTO.getId();
        this.paciente = paciente;
        this.dentista = dentista;
        this.dataHora = consultaDTO.getDataHora();
    }
}
