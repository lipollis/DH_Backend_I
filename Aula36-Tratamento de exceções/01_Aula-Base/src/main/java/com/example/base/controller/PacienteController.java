package com.example.base.controller;

import com.example.base.exceptions.ResourceNotFoundException;
import com.example.base.model.PacienteModel;
import com.example.base.services.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteServiceImpl pacienteService;


    @PostMapping("/salvar")
    public ResponseEntity<PacienteModel> salvar(@RequestBody PacienteModel paciente) {
        return ResponseEntity.ok(pacienteService.salvar(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagar(@PathVariable Integer id) throws ResourceNotFoundException {
        pacienteService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Apagado");
    }
}
