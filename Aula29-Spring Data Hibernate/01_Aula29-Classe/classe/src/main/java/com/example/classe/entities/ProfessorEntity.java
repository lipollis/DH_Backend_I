package com.example.classe.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// ASSINATURAS
@Getter //ASSINATURA LOMBOK
@Setter //ASSINATURA LOMBOK
@Entity // IDENTIFICA QUE É UMA ENTIDADE
@Table(name = "professores")// IDENTIFICA QUE É UMA TABELA
public class ProfessorEntity {

    // INDICAÇÃO DO ID DA TABELA
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "curso")
    private String curso;

    // RELAÇÃO PROF COM ALUNO (1:N)
    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    // mappedBy RELACIONA COM O ATRIBUTO 'professor' DA CLASSE 'AlunoEntity'
    // o LAZY faz as consultas no banco com as query feitas pelo hibernate automática, o FetchType.EAGER traria o
    // objeto professor e o objeto aluno junto, o Lazy busca só o aluno e traz só o aluno, e salva em memória quem tem
    // relacionamento com o aluno
    private Set<AlunoEntity> alunos = new HashSet<>();
    // CASCADE - quando deletar o professor também deleta os alunos
}
