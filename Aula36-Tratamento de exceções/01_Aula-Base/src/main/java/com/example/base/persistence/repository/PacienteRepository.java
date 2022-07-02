package com.example.base.persistence.repository;

import com.example.base.persistence.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Integer> {
    Optional<PacienteEntity> buscarNome(String nomePaciente);
}
