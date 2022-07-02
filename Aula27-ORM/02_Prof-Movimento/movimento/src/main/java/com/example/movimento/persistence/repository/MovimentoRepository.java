package com.example.movimento.persistence.repository;

import com.example.movimento.persistence.entities.MovimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentoRepository extends JpaRepository<MovimentoEntity, Integer> {


}
