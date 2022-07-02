public class GerenciadorComercial extends Gerenciador{

    // IMPLEMENTAÇÃO DO MÉTODO E LÓGICA - AS VARIAVEIS ESTÃO EM "GERENCIADOR"
    @Override
    public void verificar(Mail mail) {
        if((mail.getDestino().equalsIgnoreCase("comercial@colmeia.com")) ||
                (mail.getAssunto().equalsIgnoreCase("Comercial"))) {
            System.out.println("Enviado ao departamento comercial.");
        } else {
            if(this.getGerenciadorSeguinte() != null){
                this.getGerenciadorSeguinte().verificar(mail);
            }
        }
    }

            /*
        @Override
    public void verificar(Mail mail) {
        if((mail.getDestino().equalsIgnoreCase("comercial@colmeia.com")) ||
                (mail.getAssunto().equalsIgnoreCase("Comercial"))) {
            System.out.println("Enviado ao departamento comercial.");
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
