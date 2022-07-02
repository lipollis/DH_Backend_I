package service;

import entities.Produto;

import java.util.ArrayList;
import java.util.List;

// SUBSISTEMA
public class ArmazemService {

    // ATRIBUIÇÃO DO OBJETO
    private List<Produto> produtos;

    // CONSTRUTOR DO OBJETO
    public ArmazemService(List<Produto> produtos) {
        this.produtos = produtos;
    }

    //
    public Produto buscarProduto(String produtoId, Integer quantidade) {
        Produto produto = null;
        for (Produto p : this.produtos) {
            if (p.getProdutoId().equals(produtoId) && p.getQuantidade() >= quantidade)
                produto = p;
            p.setQuantidade(p.getQuantidade() - quantidade); // atualizamos a quantidade
            produto.setQuantidade(quantidade);

        }

        return produto;
    }
}
