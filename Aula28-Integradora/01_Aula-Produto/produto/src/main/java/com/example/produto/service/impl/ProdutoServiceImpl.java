package com.example.produto.service.impl;

import com.example.produto.persistence.entities.ProdutoEntity;
import com.example.produto.persistence.repository.ProdutoRepository;
import com.example.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    // VARIÁVEL DO REPOSITORY
    private final ProdutoRepository produtoRepository;

    // CONSTRUTOR
    @Autowired
    public ProdutoServiceImpl(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    // IMPLEMENTAÇÃO DOS MÉTODOS
    @Override
    public ProdutoEntity salvar(ProdutoEntity produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<ProdutoEntity> buscarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public void deletar(Integer id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public ProdutoEntity editar(ProdutoEntity produto) {
        // PRODUTO QUE CHEGA E PRODUTO QUE ESTÁ NA BASE
        ProdutoEntity produtoBase = produtoRepository.getById(produto.getId());

        // VALIDAÇÕES
        if(produto.getNome() != null)
            produtoBase.setNome(produto.getNome());

        if(produto.getQuantidade() != null)
            produtoBase.setQuantidade(produto.getQuantidade());

        if(produto.getDescricao() != null)
            produtoBase.setDescricao(produto.getDescricao());

        return produtoRepository.saveAndFlush(produtoBase);
    }
}
