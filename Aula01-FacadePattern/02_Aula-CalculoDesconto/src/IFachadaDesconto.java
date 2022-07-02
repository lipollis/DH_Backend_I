import entities.Cartao;
import entities.Produto;

public interface IFachadaDesconto {

    // MÉTODO
    public int desconto(Cartao cartao, Produto prod, int quantidade);

}

