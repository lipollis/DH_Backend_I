package entities;

public class Endereco {
    // 1. ATRIBUIÇÃO DO OBJETO
    private String rua;
    private String nro;
    private String codigoPostal;
    private String bairro;
    private String cidade;

    // 2. CONSTRUTOR DO OBJETO
    public Endereco(String rua, String nro, String codigoPostal, String bairro, String cidade) {
        this.rua = rua;
        this.nro = nro;
        this.codigoPostal = codigoPostal;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    // 3. GETTER E SETTER
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    // toString

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", nro='" + nro + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
