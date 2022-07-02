package api;

import entities.Produto;

public class ApiProduto {

    public int desconto(Produto prod){
        if (prod.getTipo().compareTo("Latas")==0){
            return 10;
        }
        return 0;
    }
}
