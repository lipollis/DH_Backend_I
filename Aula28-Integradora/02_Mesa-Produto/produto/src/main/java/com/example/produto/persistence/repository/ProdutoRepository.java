package com.example.produto.persistence.repository;

import com.example.produto.persistence.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// EXTENDS - HERDAR
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {
    // COMUNICAÇÃO COM O BANCO
}
