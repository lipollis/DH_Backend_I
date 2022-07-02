package com.example.clinicaOdonto.model;

import com.example.clinicaOdonto.dto.EnderecoDTO;
import lombok.Getter;
import lombok.Setter;

// ASSINATURA LOMBOK
@Getter
@Setter
public class Endereco {

    // ATRIBUTOS
    private Integer id;
    private String rua;
    private String numero;

    // CONSTRUTOR VAZIO - PARA QUANDO SOBREESCREVER
    public Endereco(){} //

    // MÉTODO CONSTRUTOR - COMPARTILHAR AS INFORMAÇÕES - CONVERSÃO
    public Endereco(EnderecoDTO enderecoDTO) {
        this.id = enderecoDTO.getId();
        this.rua = enderecoDTO.getRua();
        this.numero = enderecoDTO.getNumero();
    }
}
