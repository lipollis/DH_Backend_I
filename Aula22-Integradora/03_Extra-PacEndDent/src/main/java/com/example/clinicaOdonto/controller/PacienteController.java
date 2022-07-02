package com.example.clinicaOdonto.controller;

import com.example.clinicaOdonto.model.Paciente;
import com.example.clinicaOdonto.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController //ASSINATURA
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteServiceImpl pacienteService;

    // MÉTODO
    @PostMapping
    public ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.salvar(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarId(@PathVariable Integer id){
        return ResponseEntity.ok(pacienteService.buscarId(id));
    }


    @GetMapping
    public Map<Integer, Paciente> buscarTodos(){
        return pacienteService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){
        ResponseEntity<String> response= null;

        if(pacienteService.buscarId(id) != null){
            pacienteService.deletar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Paciente deletado");
        } else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado.");
        }

        return response;
    }

    @PutMapping
    public ResponseEntity<Paciente> atualizar(@RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response = null;

        // VALIDAÇÃO
        if(paciente.getId() != null && paciente.getEndereco().getId() != null)
            response = ResponseEntity.ok(pacienteService.atualizar(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;

    }
}
