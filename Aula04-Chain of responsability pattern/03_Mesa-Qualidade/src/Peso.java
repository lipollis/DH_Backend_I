public class Peso extends PadraoQualidade {

    public void avaliarProduto(Artigo produto) {
        if (produto.getPeso()>1199 && produto.getPeso()<1301){
            this.getVerifica().avaliarProduto(produto);
        }else {
            System.out.println("O peso está errado.");
        }
    }
}
