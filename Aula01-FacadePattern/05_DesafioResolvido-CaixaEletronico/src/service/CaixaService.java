import java.util.Random;

public class CaixaService {

    // MÉTODO QUE VERIFICA O VALOR SOLICITADO PARA O SAQUE
    public Double sacarDinheiro(Double valor) {
        Double dinheiroASacar = null;
        if (verificarDinheiro(valor))
            dinheiroASacar = valor;
        System.out.println("Sacando: "+ valor);
        return dinheiroASacar;

    }

    //
    private Boolean verificarDinheiro(Double valor) {
        return new Random().nextBoolean();
    }


}