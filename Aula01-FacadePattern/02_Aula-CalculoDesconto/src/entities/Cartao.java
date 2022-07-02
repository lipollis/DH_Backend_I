package entities;

public class Cartao {

    // 1. ATRIBUIÇÃO DO OBJETO
    private String numero;
    private String banco;

    // 2. CONSTRUTOR DO OBJETO
    public Cartao(String numero, String banco){
        this.numero = numero;
        this.banco = banco;
    }

    // CONSTRUTOR VAZIO
    public Cartao(){};

    // 3. GETTER E SETTER
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }


}