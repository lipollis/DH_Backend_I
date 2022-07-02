package com.example.movimento.service;


import com.example.movimento.persistence.entities.MovimentoEntity;
import com.example.movimento.persistence.repository.MovimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// INSTANCIAR INTERFACE
@Service
public class MovimentoService {

    @Autowired
    MovimentoRepository movimentoRepository;

    // MÉTODO QUE RETORNA STRING
    public String save(MovimentoEntity movimento){
        if(movimentoRepository.save(movimento) != null){
            return "ok";
        } else {
            return null;
        }

    }

    // MÉTODO RETORNA UMA LISTA DE MOVIMENTOENTITY
    public List<MovimentoEntity> ObterTodos(){
        return movimentoRepository.findAll();
    }
}
