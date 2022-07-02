package com.example.pacote.repository;

import com.example.pacote.entities.PacoteEntity;
import com.example.pacote.enums.StatusEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // ASSINATURA SPRING

// HERDA DO MongoRepository, COMUNICA COM O ENTITY, E RECEBE O ID STRING
public interface PacoteRepository extends MongoRepository<PacoteEntity, String> {

    //MÉTODO PARA RESPOSTA DO STATUS - PESQUISA TODOS OS STATUS
    List<PacoteEntity> findAllByStatus(StatusEnum status);
}
