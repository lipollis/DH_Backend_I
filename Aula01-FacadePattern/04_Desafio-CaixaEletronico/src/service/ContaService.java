public class ContaService {

    // MÉTODO COM AS INFORMAÇÕES DA CONTA
    /*public void getConta(String userID, String senha, double saldo){
        if((userID=="aline") && (senha=="0000")){
            System.out.println("Olá " + userID + " , você possui saldo atual de " + saldo);
        } else {
            System.out.println("Usuário não identificado.");
        }

    }*/

    public void getConta(String userID, String senha, double saldo) {
        if((userID=="aline") && (senha=="0000")){
            System.out.println("Olá " + userID + " , você possui saldo atual de " + saldo);
        } else {
            System.out.println("Usuário ou senha não identificado.");
        }
    }
}
