package com.example.clinicaOdonto.controller;

import com.example.clinicaOdonto.model.Consulta;
import com.example.clinicaOdonto.service.impl.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    //
    @Autowired
    private ConsultaServiceImpl consultaService;

    @PostMapping
    public ResponseEntity salvarConsulta(@RequestBody Consulta consulta) {
        Consulta consultaRetorno = consultaService.salvar(consulta);

        if(consultaRetorno != null)
            return ResponseEntity.ok(consultaRetorno);

        return ResponseEntity.badRequest().body("Paciente e/ou dentista não encontrado");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarConsultaPorId(@PathVariable Integer id) {
        Consulta consulta = consultaService.buscarId(id);
        if(consulta != null)
            return ResponseEntity.ok(consulta);
        return ResponseEntity.badRequest().body("Consulta não encontrada");
    }

        @GetMapping
    public ResponseEntity<Map<Integer, Consulta>> buscarTodasConsulta(){
        Map<Integer, Consulta> consultaMap = consultaService.buscarTodos();
        if(consultaMap.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(consultaMap);
    }

    @PutMapping
    public ResponseEntity<Consulta> atualizarConsulta(@PathVariable Integer id,@RequestBody Consulta consulta){
        Consulta consultaAtual = consultaService.atualizar(id, consulta);
        if(consultaAtual !=null){
            return ResponseEntity.ok(consultaAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public String deletarConsulta(@PathVariable Integer id) {
        consultaService.deletar(id);
        return "Consulta deletada!";
    }

}
