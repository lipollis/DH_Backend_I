public class Triangulo {

    // ATRIBUIÇÕES DO OBJETO
    private String cor;
    private int tamanho;

    // CONSTRUTOR
    public Triangulo(String cor, int tamanho) {
        this.cor = cor;
        this.tamanho = tamanho;
    }


    // GETTER & SETTER
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
