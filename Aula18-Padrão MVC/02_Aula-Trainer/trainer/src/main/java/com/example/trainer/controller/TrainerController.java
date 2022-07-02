package com.example.trainer.controller;

import com.example.trainer.domain.Trainer;
import com.example.trainer.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("trainer") // CHAMA A API
public class TrainerController {
    // CRIA A CHAMADA
    private final TrainerService trainerService;

    // INSTANCIADO O PARÂMETRO
    @Autowired // CONEXÃO DO MODEL COM O Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    // QUEM ESTÁ SE CHAMANDO
    @GetMapping
    //@RequestMapping() // CHAMA ESPECIFICAMENTE UM MÉTODO
    public List<Trainer> getTrainer(){
        return trainerService.listTrainer();
    }

}
