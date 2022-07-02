public class GerenciadorTecnico extends Gerenciador{

    // IMPLEMENTAÇÃO DO MÉTODO E LÓGICA - AS VARIAVEIS ESTÃO EM "GERENCIADOR"
    @Override
    public void verificar(Mail mail) {
        if((mail.getDestino().equalsIgnoreCase("tecnica@colmeia.com")) ||
                (mail.getAssunto().equalsIgnoreCase("Tecnico"))) {
            System.out.println("Enviado ao departamento técnico.");
        } else {
            if(this.getGerenciadorSeguinte() != null){
                this.getGerenciadorSeguinte().verificar(mail);
            }
        }
    }

        /*
        @Override
    public void verificar(Mail mail) {
        if((mail.getDestino().equalsIgnoreCase("tecnica@colmeia.com")) ||
                (mail.getAssunto().equalsIgnoreCase("Tecnico"))) {
            System.out.println("Enviado ao departamento técnico.");
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
