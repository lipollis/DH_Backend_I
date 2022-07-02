package entities;

public class Produto {
    // 1. ATRIBUIÇÃO DO OBJETO
    private String nome;
    private String tipo;

    // 2. CONSTRUTOR DO OBJETO
    public Produto(String nome, String tipo){
        this.nome = nome;
        this.tipo = tipo;
    }

    // 3. GETTER E SETTER
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}