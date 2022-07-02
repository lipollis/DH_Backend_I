package com.example.classe.repository.impl;

import com.example.classe.entities.ProfessorEntity;
import com.example.classe.repository.ProfessorRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public abstract class ProfessorRepositoryImpl implements ProfessorRepository {

    @Query("SELECT p FROM professores AS p WHERE p.nome = ?1 AND p.curso = ?2")
    public abstract Optional<ProfessorEntity> buscarNome(String nomeProf, String curso, String q);

    @Query("SELECT p.nome FROM professores AS p WHERE p.id = ?1")
    public abstract Optional<ProfessorEntity> buscarIdRetornoNome(Integer id);
}
