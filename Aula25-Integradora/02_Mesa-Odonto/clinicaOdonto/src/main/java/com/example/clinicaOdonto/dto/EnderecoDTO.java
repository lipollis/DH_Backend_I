package com.example.clinicaOdonto.dto;



import com.example.clinicaOdonto.model.Endereco;
import lombok.Getter;
import lombok.Setter;


// OBJETO SALVO NO BANCO

// ASSINATURA LOMBOK
@Getter
@Setter
public class EnderecoDTO {
    // ATRIBUTOS
    private Integer id;
    private String rua;
    private String numero;

    // CONSTRUTOR VAZIO
    public EnderecoDTO () {}

    // MÉTODO CONSTRUTOR - COMPARTILHAR AS INFORMAÇÕES - CONVERSÃO
    public EnderecoDTO(Endereco endereco) {
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
    }
}
