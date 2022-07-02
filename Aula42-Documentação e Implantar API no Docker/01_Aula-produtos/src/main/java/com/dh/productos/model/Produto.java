package com.dh.productos.model;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// link do swagger: http://localhost:8080/swagger-ui.html
@Document(collection = "produtos")
public class Produto {
    @Id
    @NotNull
    private Integer id;

    @NotNull
    @Size(min = 1, max = 100)
    private String nome;
    private Integer quantidade;
    private Integer preco;

    public Produto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }
}
