public class ProcessaMail {
    public static void main(String[] args) {
        // INSTANCIANDO O CheckMail
        CheckMail processo = new CheckMail();
        processo.verificarEmails(new Mail("email@email.com",
                "tecnica@digitalhouse.com",
                "Reclamação"));

        processo.verificarEmails(new Mail("email@email.com",
                "mmmm@digitalhouse.com",
                "Gerencia"));

        processo.verificarEmails(new Mail("email@email.com",
                "gerencia@colmeia.com",
                "Comercial"));
    }


}
