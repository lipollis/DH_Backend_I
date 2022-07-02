package com.example.pacote.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

// ASSINATURAS
@Getter //ASSINATURA LOMBOK
@Setter //ASSINATURA LOMBOK
public class DestinoEntity {

    private String endereco;
    private Integer numero;
    private String cidade;
    private String estado;
}
