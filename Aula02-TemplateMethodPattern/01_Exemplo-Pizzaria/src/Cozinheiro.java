public abstract class Cozinheiro {

    // MÉTODO ESQUELETO DOS PASSOS PARA PREPARAR A PIZZA
    public void fazerPizza(){
        prepararMassa();
        preCozinharMassa();
        prepararIngredientes();
        adicionarIngredientes();
        cozinharPizza();
        embalarPizza();
    }

    // MÉTODO ABSTRATO
    protected abstract  void prepararIngredientes();
    protected abstract  void adicionarIngredientes();

    // ORDEM DE CHAMADA DE CADA MÉTODO PARA PREPARAÇÃO DA PIZZA
    private void prepararMassa(){
        System.out.println("Preparando a massa...");
    }

    private void preCozinharMassa(){
        System.out.println("Pré-cozinhando a massa...");
    }

    private void cozinharPizza(){
        System.out.println("Enviando a pizza ao forno.");
    }

    private void embalarPizza(){
        System.out.println("Embalando a pizza.");
    }
}
