package com.example.clinica.controller;

import com.example.clinica.model.Paciente;
import com.example.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacienteController {
    // VARIÁVEL DO SERVIÇO QUE SERÁ ACESSADO PELO CONTROLLER
    private final PacienteService pacienteService;

    // CONSTRUTOR DA VARIÁVEL
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // MÉTODO - o Model é o que é lido no index.html
    @GetMapping("/buscarEmail")
    public String buscarEmail(Model model){
        // QUANDO ABRIR NO NAVEGADOR "localhost:8080/buscarEmail" PARA VISUALIZAR O HTML
        Paciente paciente = pacienteService.buscarEmail("neideblanco@email.com");
        //model.addAttribute("intro", "****************************************");
        model.addAttribute("paciente", "***         Olá Paciente          ***");
        //model.addAttribute("intro", "****************************************");
        model.addAttribute("nomePaciente", paciente.getNome());
        model.addAttribute("sobrenomePaciente", paciente.getSobrenome());

        return "index";
    }
}
