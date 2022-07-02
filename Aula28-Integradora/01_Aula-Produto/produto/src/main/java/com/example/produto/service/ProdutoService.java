package com.example.produto.service;

import com.example.produto.persistence.entities.ProdutoEntity;

import java.util.List;

public interface ProdutoService {
    ProdutoEntity salvar(ProdutoEntity produto);
    List<ProdutoEntity> buscarTodos();
    void deletar(Integer id);
    ProdutoEntity editar(ProdutoEntity produto);
}
