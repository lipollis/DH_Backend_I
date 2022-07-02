package com.example.produto.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// ASSINATURA LOMBOK
@Getter
@Setter
@Entity // ESSA CLASSE É UMA ENTIDADE NO HIBERNATE
@Table(name="produtos")
public class ProdutoEntity {
    // ATRIBUTOS
    @Id //DEFINE QUAL O ID DA TABELA
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // GERAR OS IDs EM SEQUÊNCIA
    @Column(name="id")
    private Integer id;

    @Column(name="nome")
    private String nome;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "descricao")
    private String descricao;

}
