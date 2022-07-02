package com.example.clinicaOdonto.controller;

import com.example.clinicaOdonto.model.Paciente;
import com.example.clinicaOdonto.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// ASSINATURAS
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired //CONEXÃO COM O SERVICE
    private PacienteServiceImpl pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.salvar(paciente));
    }

    //
    @GetMapping("/{id}")//
    public ResponseEntity buscarPacientePorId(@PathVariable Integer id) {
        Paciente paciente = pacienteService.buscarId(id);

        // TRATAMENTO DE ERRO PARA A MENSAGEM EXIBIDA AO USUÁRIO
        if(paciente != null)
            return ResponseEntity.ok(pacienteService.buscarId(id));

        //ResponseEntity.status(HttpStatus.BAD_REQUEST);

        return ResponseEntity.badRequest().body("Paciente não encontrado");
    }
}
