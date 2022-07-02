package entities;

public class Produto {
    // 1. ATRIBUIÇÃO DO OBJETO
    private String produtoId;
    private Integer quantidade;
    private Integer valor;
    private String nome;

    // 2. CONSTRUTOR DO OBJETO
    public Produto(String produtoId, Integer quantidade, Integer valor, String nome) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.valor = valor;
        this.nome = nome;
    }

    // 3. GETTER E SETTER
    public String getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // toString

    @Override
    public String toString() {
        return "Produto{" +
                "produtoId='" + produtoId + '\'' +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                ", nome='" + nome + '\'' +
                '}';
    }
}
