package com.example.base.persistence.repository.impl;

import com.example.base.persistence.entities.PacienteEntity;
import com.example.base.persistence.repository.PacienteRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

// ABSTRACT PQ QDO IMPLEMENTAR O REPOSITORY NÃO TRAZER TUDO DO JPA. CONTINUAÇÃO DO REPOSITORY MAS COM NOVAS QUERY
public abstract class PacienteRepositoryImpl implements PacienteRepository {

    // AQUI O HIPERBANATE PRODUZ A QUERY PARA O BANCO
    @Query("SELECT p FROM paciente p where p.nome = ?1")
    public abstract Optional<PacienteEntity> buscarNome(String nomePaciente);
}
