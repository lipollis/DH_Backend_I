import entities.Cartao;
import entities.Endereco;
import entities.Produto;
import service.ArmazemService;
import service.EnvioService;
import service.PgtoService;

import java.util.Arrays;
/* Definimos a classe CompraService que atuará como uma
fachada (facade), recebendo solicitações e se comunicando com os
subsistemas para que, em conjunto, a compra seja concluída*/

// FACADE PATTERN
public class CompraService implements ICompraService{

    // CHAMADA DOS APIs
    private ArmazemService armazemService;
    private PgtoService pgtoService;
    private EnvioService envioService;

    // CONSTRUTOR PARA INSTANCIAR AS APIs
    public CompraService(ArmazemService armazemService, PgtoService pgtoService, EnvioService envioService) {
        this.armazemService = armazemService;
        this.pgtoService = pgtoService;
        this.envioService = envioService;
    }

    // MÉTODO DE IMPLEMENTAÇÃO COM A INTERFACE

    public void processarCompra(String produtoId, Integer quantidade, Cartao cartao, Endereco endereco) {
        Produto produto = armazemService.buscarProduto(produtoId, quantidade);
        if(produto != null){
            //Se temos o produto, processamos o pagamento
            if(pgtoService.processarPgto(cartao,String.valueOf(produto.getValor() * quantidade))){
                envioService.processarEnvio(Arrays.asList(produto), endereco);
            }

        }
    }
}
