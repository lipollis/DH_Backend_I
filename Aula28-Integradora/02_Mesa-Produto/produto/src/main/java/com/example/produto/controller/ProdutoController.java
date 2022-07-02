package com.example.produto.controller;

import com.example.produto.persistence.entities.ProdutoEntity;
import com.example.produto.service.impl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoServiceImpl produtoService;

    @PostMapping("/salvar") //localhost:8080/produto
    public ResponseEntity salvar(@RequestBody ProdutoEntity produto){
        return ResponseEntity.ok(produtoService.salvar(produto));
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity buscarTodos(){
        return ResponseEntity.ok(produtoService.buscarTodos());
    }

    @PutMapping("/atualizar")
    public ResponseEntity atualizar(@RequestBody ProdutoEntity produto){
        return ResponseEntity.ok(produtoService.editar(produto));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@RequestBody Integer id) {
        produtoService.deletar(id);
    }

    @GetMapping("/subtrair/{id}/{quantidade}")
    public ResponseEntity<ProdutoEntity> subtrair(@PathVariable Integer id, @PathVariable Integer quantidade){
        ProdutoEntity produto = produtoService.subtrair(id, quantidade);

        if(produto != null)
            return ResponseEntity.ok(produto);
        else
            return ResponseEntity.internalServerError().body(null);
    }
}
