import api.ApiCartao;
import api.ApiProduto;
import api.ApiQuantidade;
import entities.Cartao;
import entities.Produto;

public class FachadaDesconto implements IFachadaDesconto{
    // 2. CHAMADA DOS APIs
    private ApiCartao apiCartao;
    private ApiProduto apiProduto;
    private ApiQuantidade apiQuantidade;

    // 3. CONSTRUTOR PARA INSTANCIAR AS APIs
    public FachadaDesconto() {
        this.apiCartao = new ApiCartao();
        this.apiProduto = new ApiProduto();
        this.apiQuantidade = new ApiQuantidade();
    }

    // 1. MÉTODO DE IMPLEMENTAÇÃO COM A INTERFACE
    public int desconto(Cartao cartao, Produto prod, int quantidade) {
        int desconto = 0;
        desconto =  apiQuantidade.desconto(quantidade)
                + apiProduto.desconto(prod)
                + apiCartao.desconto(cartao);
        return desconto;
    }
}