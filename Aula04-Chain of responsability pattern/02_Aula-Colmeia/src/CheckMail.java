// ELO ENTRE OS RAMOS
public class CheckMail {

    // DEFINIR POR ONDE INICIA - ORDEM = INSTANCIAR AS VARIAVEIS
    Gerenciador inicial;

    // CONSTRUTOR, NÃO RECEBE MAS DEFINE A ORDEM
    public CheckMail(){
        this.inicial = new GerenciadorGerencia();
        Gerenciador tecnico = new GerenciadorTecnico();
        Gerenciador comercial = new GerenciadorComercial();
        Gerenciador spam = new GerenciadorSpam();

        // determina já quem será o próximo, depois do inicial
        inicial.setGerenciadorSeguinte(tecnico);
        comercial.setGerenciadorSeguinte(comercial);
        tecnico.setGerenciadorSeguinte(spam);

    }

    // CHAMANDO
    public void verificarEmails(Mail mail){
        inicial.verificar(mail);
    }
}
