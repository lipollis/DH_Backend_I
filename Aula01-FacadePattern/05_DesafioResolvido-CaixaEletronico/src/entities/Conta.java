public class Conta {

    // ATRIBUIÇÃO DE OBJETO
    private String idUsuario;
    private Double saldo;

    // CONSTRUTOR DO OBJETO
    public Conta(String idUsuario, Double saldo) {
        this.idUsuario = idUsuario;
        this.saldo = saldo;
    }

    // GETTER & SETTER
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
