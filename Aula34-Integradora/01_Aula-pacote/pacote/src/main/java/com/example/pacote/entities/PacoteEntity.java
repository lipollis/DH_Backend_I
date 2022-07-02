package com.example.pacote.entities;

import com.example.pacote.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

// ASSINATURAS
@Getter //ASSINATURA LOMBOK
@Setter //ASSINATURA LOMBOK
@Document(collection = "pacotes")
public class PacoteEntity {

    @Id
    private String id;
    private Integer codigo;

    @Field(name = "nome_produto") // USADO PARA O NOME DAS COLUNAS QUANDO DIFERENTE DO NOME DO ATRIBUTO DA CLASSE
    private String nomeProduto;
    private StatusEnum status;
    private DestinoEntity destino;
}
