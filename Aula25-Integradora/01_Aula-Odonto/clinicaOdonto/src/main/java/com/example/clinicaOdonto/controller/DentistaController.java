package com.example.clinicaOdonto.controller;

import com.example.clinicaOdonto.model.Dentista;
import com.example.clinicaOdonto.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

    @PostMapping
    public ResponseEntity<Dentista> salvarPaciente(@RequestBody Dentista dentista) {
        return ResponseEntity.ok(dentistaService.salvar(dentista));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPacientePorId(@PathVariable Integer id) {
        Dentista dentista = dentistaService.buscarId(id);

        if(dentista != null)
            return ResponseEntity.ok(dentista);

        return ResponseEntity.badRequest().body("Paciente não encontrado");
    }
}