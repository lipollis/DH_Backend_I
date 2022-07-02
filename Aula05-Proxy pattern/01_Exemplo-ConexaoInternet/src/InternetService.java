public class InternetService implements iConexaoInternet{

    // MÉTODO IMPLEMENTADO
    @Override
    public void conectarCom(String url) {
        System.out.println("Conectando com " + url);
    }
}
