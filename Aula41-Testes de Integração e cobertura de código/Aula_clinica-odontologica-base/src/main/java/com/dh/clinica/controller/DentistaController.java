package com.dh.clinica.controller;

import com.dh.clinica.model.Dentistas;

import com.dh.clinica.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/dentistas")
public class DentistaController {
    @Autowired
    private DentistaService dentistaService;

    @PostMapping()
    public ResponseEntity<Dentistas> registrarDentista(@RequestBody Dentistas dentistas) {

        return ResponseEntity.ok(dentistaService.registrarDentista(dentistas));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentistas> buscar(@PathVariable Integer id) {
        Dentistas dentistas = dentistaService.buscar(id).orElse(null);

        return ResponseEntity.ok(dentistas);
    }

    @PutMapping()
    public ResponseEntity<Dentistas> atualizar(@RequestBody Dentistas dentistas) {
        ResponseEntity<Dentistas> response = null;

        if (dentistas.getId() != null && dentistaService.buscar(dentistas.getId()).isPresent())
            response = ResponseEntity.ok(dentistaService.atualizar(dentistas));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagar(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if (dentistaService.buscar(id).isPresent()) {
            dentistaService.apagar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Apagado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
    @GetMapping
    public ResponseEntity<List<Dentistas>> buscarTodos(){
        return ResponseEntity.ok(dentistaService.buscarTodos());
    }



}
