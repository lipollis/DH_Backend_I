package com.example.clinicaOdonto.controller;

import com.example.clinicaOdonto.model.Paciente;
import com.example.clinicaOdonto.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController //ASSINATURA
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // MÉTODO - o Model é o que é lido no index.html
    @GetMapping("criar")
    public Paciente criarPaciente(){
        // QUANDO ABRIR NO NAVEGADOR "localhost:8080/criar" PARA VISUALIZAR O HTML
        return pacienteService.criarPaciente();
    }

    @GetMapping("listar")
    public Map<Integer, Paciente> listarPacientes(){
        return pacienteService.buscarPacientes();
    }

    @GetMapping("deletar/{id}") //PARA RECONHECER QUAL ID QUER DELETAR. TAMBEM PODERIA TER MAIS QUE UM "deletar/{id}/{nome}"
    public String deletarPaciente(@PathVariable Integer id){ //(@PathVariable Integer id, (@PathVariable String nome))
        pacienteService.deletar(id);

        return "Paciente deletado";
    }

    @GetMapping("atualizar/{id}/{nome}") //PARA RECONHECER QUAL ID QUER ATUALIZAR.
    public Paciente atualizarPaciente(@PathVariable Integer id, @PathVariable String nome){
        return pacienteService.atualizarPaciente(id, nome);

    }
}
