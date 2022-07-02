public class Deputados extends Documentos {


    @Override
    public void conteudoDoDocumento(Integer tipoDeDocumento, String texto) {
        if (tipoDeDocumento==1){
            System.out.println("Acesso do documento permitido para os Deputados.");
            this.tipoDeDocumento.conteudoDoDocumento(tipoDeDocumento, texto);
        } else if (this.tipoDeDocumento != null) {
            this.tipoDeDocumento.conteudoDoDocumento(tipoDeDocumento, texto);
        }
    }
}
