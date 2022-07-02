package model;

public class Endereco {
    // ATRIBUTOS
    private Integer id;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    //private Integer idPaciente;

    // CONSTRUTOR
    public Endereco(String rua, String numero, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        //this.idPaciente = idPaciente;
    }

    public Endereco(
            Integer id, String rua, String numero, String cidade, String estado) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        //this.idPaciente = idPaciente;
    }

    // GETTER & SETTER
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    /*public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }*/

    // toString
    @Override
    public String toString() {
        return "\nEndereco{" +
               "\nidEndereco =" + id +
               //"|| idPaciente=" + idPaciente +
               " -- rua " + rua +
               ", " + numero +
               "\n " + cidade +
               " - " + estado +
               "\n}";
    }
}
