package entities;

import java.util.Date;

public class Cartao {
    // 1. ATRIBUIÇÃO DO OBJETO
    private String numerosFrente;
    private String codSeguranca;
    private String dataVencimento;

    // 2. CONSTRUTOR DO OBJETO
    public Cartao(String numerosFrente, String codSeguranca, String dataVencimento) {
        this.numerosFrente = numerosFrente;
        this.codSeguranca = codSeguranca;
        this.dataVencimento = dataVencimento;
    }

    // 3. GETTER E SETTER
    public String getNumerosFrente() {
        return numerosFrente;
    }

    public void setNumero(String numero) {
        this.numerosFrente = numerosFrente;
    }

    public String getCodSeguranca() {
        return codSeguranca;
    }

    public void setCodSeguranca(String codSeguranca) {
        this.codSeguranca = codSeguranca;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    // toString
    @Override
    public String toString() {
        return "Cartao{" +
                "numerosFrente='" + numerosFrente + '\'' +
                ", codSeguranca='" + codSeguranca + '\'' +
                ", dataVencimento='" + dataVencimento + '\'' +
                '}';
    }
}
