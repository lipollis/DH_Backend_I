public class Usuario {

    // ATRIBUIÇÃO DO OBJETO
    private String userID;
    private String senha;
    private double saldo;

    // CONSTRUTOR DO OBJETO
    public Usuario(String userID, String senha, double saldo) {
        this.userID = userID;
        this.senha = senha;
        this.saldo = saldo;
    }


    // GETTER E SETTER
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
