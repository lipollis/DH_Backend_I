import java.util.Random;

public class AuthenticationService {

    // MÉTODO PARA AUTENTIFICAR O USUÁRIO
    public Boolean validateUserAndPassword(String usuario, String senha) {
        System.out.println("Validando usuário: " + usuario);
        Boolean dadosValidos = Boolean.FALSE;
        if (usuario != null & senha != null)
            dadosValidos = validar(usuario, senha);

        return dadosValidos;
    }

    //
    private Boolean validar(String usuario, String senha) {
        return new Random().nextBoolean();
    }
}