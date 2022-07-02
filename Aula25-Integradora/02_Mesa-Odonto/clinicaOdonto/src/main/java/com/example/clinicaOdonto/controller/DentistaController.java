package com.example.clinicaOdonto.controller;

import com.example.clinicaOdonto.model.Dentista;
import com.example.clinicaOdonto.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public ResponseEntity buscarDentistaPorId(@PathVariable Integer id) {
        Dentista dentista = dentistaService.buscarId(id);

        if(dentista != null)
            return ResponseEntity.ok(dentista);

        return ResponseEntity.badRequest().body("Dentista não encontrado");
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Dentista>> buscarTodosDentistas(){
        Map<Integer, Dentista> dentistaMap = dentistaService.buscarTodos();
        if(dentistaMap.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dentistaMap);
    }

    @PutMapping
    public ResponseEntity<Dentista> atualizarDentista(@PathVariable Integer id,@RequestBody Dentista dentista){
        Dentista dentistaAtual = dentistaService.atualizar(id, dentista);
        if(dentistaAtual !=null){
            return ResponseEntity.ok(dentistaAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public String deletarDentista(@PathVariable Integer id) {
        dentistaService.deletar(id);
        return "Dentista deletado!";
    }

}