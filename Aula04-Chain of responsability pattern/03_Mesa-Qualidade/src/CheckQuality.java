public class CheckQuality {
    PadraoQualidade analisa;

    public CheckQuality () {
        this.analisa = new Lote();
        PadraoQualidade peso = new Peso();
        PadraoQualidade emvalagem = new Embalagem();

        analisa.setVerifica(peso);
        peso.setVerifica(emvalagem);
    }
    public void verificarQualidade (Artigo produto) {
        this.analisa.avaliarProduto(produto);}
}
