import entities.Cartao;
import entities.Endereco;
import entities.Produto;
import service.ArmazemService;
import service.EnvioService;
import service.PgtoService;

import java.util.Arrays;



public class Main {

    public static void main(String[] args) {
        Produto produtoUm = new Produto("1", 5, 1000, "Mouse");
        Produto produtoDois = new Produto("2",5,3000,"Teclado");

        Cartao cartao = new Cartao("1111222233334444", "012", "2025/07/09");
        Endereco endereco = new Endereco("Av Morumbi", "1500", "14280000", "Morumbi", "São Paulo");

        ICompraService compraService = new CompraService(new ArmazemService(Arrays.asList(produtoUm, produtoDois)),
                                                         new PgtoService(),
                                                         new EnvioService());

        compraService.processarCompra("1",3,cartao,endereco);

    }
}
