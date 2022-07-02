public abstract class Documentos {
    protected Documentos tipoDeDocumento;

    public abstract void conteudoDoDocumento(Integer tipoDeDocumento, String texto);

    public Documentos setTipoDeDocumento (Documentos tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
        return this;
    }
}
