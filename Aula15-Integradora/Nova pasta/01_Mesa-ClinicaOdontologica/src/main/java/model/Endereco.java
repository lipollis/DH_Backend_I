package model;

public class Endereco {
    // ATRIBUTOS
    private Integer idEnd;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;

    // CONSTRUTOR
    public Endereco(Integer idEnd, String rua, String numero, String cidade, String estado) {
        this.idEnd = idEnd;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    // GETTER & SETTER
    public Integer getIdEnd() {
        return idEnd;
    }

    public void setIdEnd(Integer idEnd) {
        this.idEnd = idEnd;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
