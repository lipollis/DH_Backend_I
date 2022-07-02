package com.example.movimento.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter // ASSINATURA LOMBOK
@Setter // ASSINATURA LOMBOK
@Entity // ASSINATURA ENTITY - RELACIONAMENTO COM O BANCO - ONDE GERA A TABELA DO BANCO DE DADOS
@Table(name="TABLA_MOVIMENTOS") //RELAÇÃO BANCO DE DADOS - NOME DA TABELA

public class MovimentoEntity {

    @Id // ASSINATURA JPA - DETERMINAR QUE ATRIBUTO É O ID DA TABELA
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // GERADOR DE ID - CRIAÇÃO VIA HIBERNATE
    @Column(name="ID") // DETERMINA O NOME DA COLUNA, SENÃO USAR A ASSINATURA O DB CRIA COM O NOME DA VARIÁVEL
    private Integer id;

    @Column(name = "DESC")
    private String descricao;


    @Column(name = "QUANTIA")
    private Double quantidade;
}
