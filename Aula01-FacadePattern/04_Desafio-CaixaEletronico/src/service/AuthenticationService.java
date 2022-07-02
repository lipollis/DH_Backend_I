public class AuthenticationService {

    // MÉTODO PARA AUTENTICAÇÃO DO USUÁRIO
    public void validateUserAndPassword(String userID, String senha){
        if((userID=="aline") && (senha=="0000")){
            System.out.println("================================");
            System.out.println("Bem vinda cliente " + userID);
        } else {
            System.out.println("================================");
            System.out.println("Usuário não identificado.");
        }
    }
}
