package api;

public class ApiQuantidade {

    public int desconto(int quant){
        if (quant > 11){
            return 15;
        }
        return 0;
    }
}
