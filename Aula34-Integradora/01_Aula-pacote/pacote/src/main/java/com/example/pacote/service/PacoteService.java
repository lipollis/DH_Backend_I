package com.example.pacote.service;

import com.example.pacote.entities.PacoteEntity;
import com.example.pacote.enums.StatusEnum;
import com.example.pacote.repository.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //ASSINATURA
public class PacoteService {

    @Autowired //COMO É UMA INTERFACE DO REPOSITORY, NÃO TEM CONSTRUTOR
    private PacoteRepository pacoteRepository;

    // PARA SALVAR - SALVO O DESTINO DENTRO DO PACOTE - COMO É RELACIONAL NÃO PRECISA DE DUAS TABELAS SEPARADAS
    public PacoteEntity salvar(PacoteEntity pacote){
        return pacoteRepository.save(pacote);
    }

    public List<PacoteEntity> buscarTodos(){
        return pacoteRepository.findAll();
    }

    public List<PacoteEntity> buscarACaminho(){
        return pacoteRepository.findAllByStatus(StatusEnum.A_CAMINHO);
    }
}
