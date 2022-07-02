public abstract class Menu {

    // ATRIBUTOS
    private String descricao;
    private double precoMenu;

    // CONSTRUTOR DO OBJETO
    public Menu(String descricao, double precoMenu) {
        this.descricao = descricao;
        this.precoMenu = precoMenu;
    }

    // MÉTODOS ESQUELETO DE CADA MENU
    public void preparacao(){
        montado();

    }

    // MÉTODO ABSTRATO
    protected abstract void montado();


    // ORDEM DE CHAMADA DE CADA MÉTODO
}
