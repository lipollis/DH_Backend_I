package com.example.clinicaOdonto.controller;

import com.example.clinicaOdonto.model.Dentista;
import com.example.clinicaOdonto.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController //ASSINATURA
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

    // MÉTODO
    @PostMapping
    public ResponseEntity<Dentista> salvarDentista(@RequestBody Dentista dentista){
        return ResponseEntity.ok(dentistaService.salvar(dentista));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentista> buscarId(@PathVariable Integer id){
        return ResponseEntity.ok(dentistaService.buscarId(id));
    }


    @GetMapping
    public Map<Integer, Dentista> buscarTodos(){
        return dentistaService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id){
        ResponseEntity<String> response= null;

        if(dentistaService.buscarId(id) != null){
            dentistaService.deletar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Dentista deletado");
        } else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dentista não encontrado.");
        }

        return response;
    }

    @PutMapping
    public ResponseEntity<Dentista> atualizar(@RequestBody Dentista dentista) {
        ResponseEntity<Dentista> response = null;

        // VALIDAÇÃO
        if(dentista.getId() != null)
            response = ResponseEntity.ok(dentistaService.atualizar(dentista));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;

    }
}
