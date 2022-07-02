package service;

import entities.Endereco;
import entities.Produto;

import java.util.List;

// SUBSISTEMA
public class EnvioService {

    // MÉTODO PARA PROCESSAMENTO DO ENVIO
    public void processarEnvio(List<Produto> produtos, Endereco endereco){
        System.out.println("Enviando produtos a "
                + endereco.getRua() + " "
                + endereco.getNro() + ", "
                + endereco.getBairro());
    }
}
