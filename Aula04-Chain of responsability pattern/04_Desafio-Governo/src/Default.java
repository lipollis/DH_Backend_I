public class Default extends Documentos {

    @Override
    public void conteudoDoDocumento(Integer tipoDeDocumento, String texto) {
        if (tipoDeDocumento>3) {
            System.out.println("Não foi possível classificar esse documento.");
        }
    }
}
