public class GerenciadorSpam extends Gerenciador{

    // IMPLEMENTAÇÃO DO MÉTODO E LÓGICA - AS VARIAVEIS ESTÃO EM "GERENCIADOR"
    @Override
    public void verificar(Mail mail) {
        System.out.println("Marcado como spam.");
    }
}
