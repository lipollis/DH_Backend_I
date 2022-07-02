package com.example.pacote.controller;

import com.example.pacote.entities.PacoteEntity;
import com.example.pacote.service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacotes") //DEFINE A URL
public class PacoteController {

    @Autowired
    private PacoteService pacoteService;

    @PostMapping("/salvar")
    public ResponseEntity<PacoteEntity> salvar(@RequestBody PacoteEntity pacote){
        return ResponseEntity.ok(pacoteService.salvar(pacote));
    }

    @GetMapping("/buscartodos")
    public ResponseEntity<List<PacoteEntity>> buscarTodos(){
        return ResponseEntity.ok(pacoteService.buscarTodos());
    }

    @GetMapping("/buscarcaminho")
    public ResponseEntity<List<PacoteEntity>> buscarCaminho(){
        return ResponseEntity.ok(pacoteService.buscarACaminho());
    }
}
