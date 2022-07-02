package com.dh.productos.servicio;

import com.dh.productos.model.Produto;
import com.dh.productos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto guardar(Produto p){
        return produtoRepository.save(p);
    }

    public List<Produto> listar(){
        return produtoRepository.findAll();
    }
    public Produto buscar(Integer id){
        return produtoRepository.findById(id).orElseGet(null);
    }
    public void apagar(Integer id){
        produtoRepository.deleteById(id);
    }
}
