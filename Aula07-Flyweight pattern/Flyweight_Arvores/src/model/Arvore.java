package model;

import model.enums.Cor;

public class Arvore {

    private int altura;
    private int largura;
    private Cor cor;

    public Arvore(int altura, int largura, Cor cor) {
        this.altura = altura;
        this.largura = largura;
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Arvore{" +
                "altura=" + altura +
                ", largura=" + largura +
                ", cor=" + cor +
                '}';
    }
}
