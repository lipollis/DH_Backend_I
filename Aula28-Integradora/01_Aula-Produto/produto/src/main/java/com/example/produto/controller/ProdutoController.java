package com.example.produto.controller;

import com.example.produto.persistence.entities.ProdutoEntity;
import com.example.produto.service.impl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoServiceImpl produtoService;

    @PostMapping("/salvar") //localhost:8080/produto
    public ResponseEntity salvar(@RequestBody ProdutoEntity produto){
        return ResponseEntity.ok(produtoService.salvar(produto));
    }
}
