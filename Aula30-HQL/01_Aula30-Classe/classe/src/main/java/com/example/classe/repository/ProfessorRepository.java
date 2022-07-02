package com.example.classe.repository;

import com.example.classe.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Integer> {

    @Query("SELECT p FROM professores AS p WHERE p.nome = ?1 AND p.curso = ?2")
    Optional<ProfessorEntity> buscarNome(String nomeProf, String curso, String q);

    @Query("SELECT p.nome FROM professores AS p WHERE p.id = ?1")
    Optional<ProfessorEntity> buscarIdRetornoNome(Integer id);


    // COM O PROFESSORREPOSITORYIMPL, AS QUERY NÃO FICAM NO PROFESSOR REPOSITORY
    //Optional<ProfessorEntity> buscarNome(String nomeProf, String curso, String q);
    //Optional<ProfessorEntity> buscarIdRetornoNome(Integer id);
}
