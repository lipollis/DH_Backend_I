public class GerenciadorGerencia extends Gerenciador{

    // IMPLEMENTAÇÃO DO MÉTODO E LÓGICA - AS VARIAVEIS ESTÃO EM "GERENCIADOR"
    @Override
    public void verificar(Mail mail) {
        if((mail.getDestino().equalsIgnoreCase("gerencia@colmeia.com")) ||
                (mail.getAssunto().equalsIgnoreCase("Gerencia"))) {
            System.out.println("Enviado ao departamento gerencial.");
            } else {
                if(this.getGerenciadorSeguinte() != null){
                    this.getGerenciadorSeguinte().verificar(mail);
                }
        }
    }

    /*
        @Override
    public void verificar(Mail mail) {
        if((mail.getDestino().equalsIgnoreCase("gerencia@colmeia.com")) ||
                (mail.getAssunto().equalsIgnoreCase("Gerencia"))) {
            System.out.println("Enviado ao departamento gerencial.");

                // para verificar em todos os departamentos
                if(this.getGerenciadorSeguinte() != null && !(this.getGerenciadorSeguinte() instanceof GerenciadorSpam)){
                    this.getGerenciadorSeguinte().verificar(mail);
                }

            } else {
                if(this.getGerenciadorSeguinte() != null){
                    this.getGerenciadorSeguinte().verificar(mail);
                }
        }
    }

     */
}
