package model;

import java.io.Serializable;

public class Cachorro implements Serializable {

    // ATRIBUTOS
    private String nome;
    private int idade;

    // GETTER & SETTER
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
