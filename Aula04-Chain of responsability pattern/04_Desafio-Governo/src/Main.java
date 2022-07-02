public class Main {
    public static void main(String[] args) {
        Documentos mensagem01 = new Deputados().setTipoDeDocumento(new Ministros().setTipoDeDocumento
                (new Presidente("João Paulo").setTipoDeDocumento(new Default())));

        mensagem01.conteudoDoDocumento(1, "Mensagem reservada.");
        System.out.println("----//----");
        mensagem01.conteudoDoDocumento(2, "Mensagem secreta.");
        System.out.println("----//----");
        mensagem01.conteudoDoDocumento(3, "Mensagem muito secreta.");
        System.out.println("----//----");
        mensagem01.conteudoDoDocumento(4, "Mensagem muito secreta.");



    }
}