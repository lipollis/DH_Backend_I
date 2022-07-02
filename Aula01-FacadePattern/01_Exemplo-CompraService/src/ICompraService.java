/*Através de uma interface definimos como o cliente deve se comunicar com
nosso sistema*/


import entities.Cartao;
import entities.Endereco;

public interface ICompraService {

    // IMPLEMENTAÇÃO DO MÉTODO DA INTERFACE
    public void processarCompra(String produtoId, Integer quantidade, Cartao cartao, Endereco endereco);
}