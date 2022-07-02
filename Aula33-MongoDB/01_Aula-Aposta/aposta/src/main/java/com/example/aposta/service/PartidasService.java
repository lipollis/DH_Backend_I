package com.example.aposta.service;

import com.example.aposta.entities.PartidasEntity;
import com.example.aposta.repository.PartidasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // ASSINATURA
public class PartidasService {

    @Autowired //INSTANCIAR
    private PartidasRepository partidasRepository;

    private PartidasEntity salvarPartida(PartidasEntity partidas){
        return partidasRepository.save(partidas);
    }
}
