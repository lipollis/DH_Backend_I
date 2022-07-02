package Filme;

public class Filme {

    // ATRIBUTOS DO OBJETO
    private String nome;
    private String pais;
    private String link;

    // CONSTRUTOR DO OBJETO
    public Filme(String nome, String pais, String link) {
        this.nome = nome;
        this.pais = pais;
        this.link = link;
    }

    // GETTER & SETTER
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
