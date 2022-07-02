package api;

import entities.Cartao;

public class ApiCartao {

    //MÉTODO PARA CALCULAR O DESCONTO COM O CARTÃO
    public int desconto(Cartao cartao){
        if (cartao.getBanco().compareTo("Star Bank")==0){
            return 20;
        } else {
            return 0;
        }
    }
}