package com.example.classe.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// ASSINATURAS
@Getter //ASSINATURA LOMBOK
@Setter //ASSINATURA LOMBOK
@Entity // IDENTIFICA QUE É UMA ENTIDADE
@Table(name = "alunos")// IDENTIFICA QUE É UMA TABELA
public class AlunoEntity {

    // INDICAÇÃO DO ID DA TABELA
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private Integer idade;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) // RELACIONAMENTO N:1
    // CASCADE - QUANDO DELETAR O PROFESSOR TAMBÉM DELETARÁ OS ALUNOS OU QUALQUER OUTRA CLASSE QUE SE RELACIONAR COM PROF
    @JoinColumn(name = "professor_id")
    private ProfessorEntity professor;
}
