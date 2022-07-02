package com.example.clinica.controller;

import com.example.clinica.model.Dentista;
import com.example.clinica.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DentistaController {
    // VARIÁVEL DO SERVIÇO QUE SERÁ ACESSADO PELO CONTROLLER
    private final DentistaService dentistaService;

    // CONSTRUTOR DA VARIÁVEL
    @Autowired
    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    // MÉTODO - o Model é o que é lido no index.html
    @GetMapping("/buscarId")
    public String buscarId(Model model){
        // QUANDO ABRIR NO NAVEGADOR "localhost:8080/buscarId" PARA VISUALIZAR O HTML
        Dentista dentista = dentistaService.buscarId(100);
        //model.addAttribute("intro", "****************************************");
        model.addAttribute("dentista", "***         Olá dentista          ***");
        //model.addAttribute("intro", "****************************************");
        model.addAttribute("nomeDentista", dentista.getNome());
        model.addAttribute("matricula", dentista.getMatricula());
        return "index";
    }
}
