package com.dh.productos.controller;

import com.dh.productos.model.Produto;
import com.dh.productos.servicio.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// link do swagger: http://localhost:8080/swagger-ui.html
@RestController
@RequestMapping("/produtos")
public class ProdutoController {


    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Operation(summary = "Registrar um novo produto")
    @PostMapping
    public Produto guardarProduto(@RequestBody Produto p){
        return produtoService.guardar(p);
    }

    @Operation(summary = "Listar todos os produtos")
    @GetMapping
    public List<Produto> listar(){
        return produtoService.listar();
    }

    @Operation(summary = "Deletar produto por id")
    @DeleteMapping("/{id}")
    public String apagar(@PathVariable Integer id){
        produtoService.apagar(id);
        return "eliminado";
    }

    @Operation(summary = "Buscar produto por id")
    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Integer id){
        return produtoService.buscar(id);
    }
}
