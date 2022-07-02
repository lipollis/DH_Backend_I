public class Lote extends PadraoQualidade {

    public void avaliarProduto(Artigo produto) {
        System.out.println("Analisando o produto "+produto.getNome()+".");
        if (produto.getLote()>999 && produto.getLote()<2001){
            this.getVerifica().avaliarProduto(produto);
        }else {
            System.out.println("O lote está errado.");
        }

    }
}