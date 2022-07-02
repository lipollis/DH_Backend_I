package com.example.aposta.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@EntityScan
@Document(collation = "partidas")
public class PartidasEntity {

    @Id
    private String id;

    @Field(name = "status")
    private String status;

    @Field(name = "resultado")
    private String resultado;
}
