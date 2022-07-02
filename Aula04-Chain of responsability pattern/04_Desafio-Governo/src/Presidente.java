public class Presidente extends Documentos {
    private static int controlador = 1;
    private String nome;

    public Presidente(String nome) {
        controlador++;
        if (controlador<2){
            this.nome=nome;
        } else {
            this.nome="Já existe um presidente.";
        }
    }

    @Override
    public void conteudoDoDocumento(Integer tipoDeDocumento, String texto) {

        if (tipoDeDocumento<4){
            System.out.println("Acesso do documento permitido para o Presidente.");
        } else if (this.tipoDeDocumento != null) {
            this.tipoDeDocumento.conteudoDoDocumento(tipoDeDocumento, texto);
        }
    }
}
