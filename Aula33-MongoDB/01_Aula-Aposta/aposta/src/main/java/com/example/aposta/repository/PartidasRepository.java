package com.example.aposta.repository;

import com.example.aposta.entities.PartidasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// INTERFACE CONTROLA PartidasEntity E HERDA DE MongoRepository
@Repository
public interface PartidasRepository
        extends MongoRepository<PartidasEntity, String> {
}
