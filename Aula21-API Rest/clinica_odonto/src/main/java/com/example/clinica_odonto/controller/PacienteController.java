package com.example.clinica_odonto.controller;

import com.example.clinica_odonto.model.Paciente;
import com.example.clinica_odonto.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteServiceImpl pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.salvar(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    /*@GetMapping("listar")
    public Map<Integer, Paciente> listarPacientes() {
        return pacienteService.buscarPacientes();
    }

    @GetMapping("deletar/{id}")
    public String deletarPacientes(@PathVariable Integer id) {
        pacienteService.deletar(id);

        return "Paciente deletado";
    }*/

/*    @GetMapping("atualizar/{id}/{nome}")
    public Paciente atualizarPaciente(@PathVariable Integer id, @PathVariable String nome) {
        return pacienteService.atualizarPaciente(id, nome);
    }*/
}
