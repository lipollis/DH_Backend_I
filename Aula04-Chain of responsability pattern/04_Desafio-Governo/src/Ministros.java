public class Ministros extends Documentos {

    @Override
    public void conteudoDoDocumento(Integer tipoDeDocumento, String texto) {
        if (tipoDeDocumento<3){
            System.out.println("Acesso do documento permitido para os Ministros.");
            this.tipoDeDocumento.conteudoDoDocumento(tipoDeDocumento, texto);
        } else if (this.tipoDeDocumento != null) {
            this.tipoDeDocumento.conteudoDoDocumento(tipoDeDocumento, texto);
        }
    }
}
