public class CozinheiroNoVeggie extends Cozinheiro{

    // MÉTODOS PARA IMPLEMENTAÇÃO
    @Override
    protected void prepararIngredientes() {
        System.out.println("Preparando queijo e presunto.");
    }

    @Override
    protected void adicionarIngredientes() {
        System.out.println("Adicionando os ingredientes.");
    }
}
