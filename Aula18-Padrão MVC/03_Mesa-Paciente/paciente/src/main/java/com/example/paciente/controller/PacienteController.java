package com.example.paciente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacienteController {
    // MÉTODO WELCOME TEM A MODEL COMO PARÂMETRO - COMO SE ENVIA OS DADOS
    // DO CONTROLLER PARA A VIEW
    @GetMapping("/index")
    public String welcome(Model model){
        model.addAttribute("nome", "Felipe");
        return "index";
    }
}
