package com.example.clinicaOdonto.controller;

import com.example.clinicaOdonto.model.Paciente;
import com.example.clinicaOdonto.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController //ASSINATURA
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteServiceImpl pacienteService;

    // MÉTODO - o Model é o que é lido no index.html
    @PostMapping
    public ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.salvar(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarId(@PathVariable Integer id){
        return ResponseEntity.ok(pacienteService.buscarId(id));
    }


/*
    @GetMapping("listar")
    public Map<Integer, Paciente> listarPacientes(){
        return pacienteService.buscarTodos();
    }

    @GetMapping("deletar/{id}") //PARA RECONHECER QUAL ID QUER DELETAR. TAMBEM PODERIA TER MAIS QUE UM "deletar/{id}/{nome}"
    public String deletarPaciente(@PathVariable Integer id){ //(@PathVariable Integer id, (@PathVariable String nome))
        pacienteService.deletar(id);

        return "Paciente deletado";
    }*/

   /*@GetMapping("atualizar/{id}/{nome}") //PARA RECONHECER QUAL ID QUER ATUALIZAR.
    public Paciente atualizarPaciente(@PathVariable Integer id, @PathVariable String nome){
        return pacienteService.atualizar();

    }*/
}
