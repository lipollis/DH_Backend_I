public class Embalagem extends PadraoQualidade {

    public void avaliarProduto(Artigo produto) {
        if (produto.getEmbalagem().equalsIgnoreCase("saudável") ||
                produto.getEmbalagem().equalsIgnoreCase("quase saudável")){
            System.out.println("O produto foi aceito.");
        }else {
            System.out.println("A embalagem está errada.");
        }
    }
}