package com.example.clinicaOdonto.dto;

import com.example.clinicaOdonto.model.Consulta;
import com.example.clinicaOdonto.model.Dentista;
import com.example.clinicaOdonto.model.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// ASSINATURA DO LOMBOOK
@Getter
@Setter
public class ConsultaDTO {
    // ATRIBUTOS
    private Integer id;
    private Integer idPaciente;
    private Integer idDentista;
    private Date dataHora;

    // CONSTRUTOR VAZIO
    public ConsultaDTO () {}

    // MÉTODO CONSTRUTOR PARA CONVERSÃO
    public ConsultaDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.idPaciente = consulta.getPaciente().getId();
        this.idDentista = consulta.getDentista().getId();
        this.dataHora = consulta.getDataHora();
    }
}
