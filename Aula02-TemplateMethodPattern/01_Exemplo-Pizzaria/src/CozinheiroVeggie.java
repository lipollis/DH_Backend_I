public class CozinheiroVeggie extends Cozinheiro{

    // MÉTODOS PARA IMPLEMENTAÇÃO
    @Override
    protected void prepararIngredientes() {
        System.out.println("Preparando queijo e tomate.");
    }

    @Override
    protected void adicionarIngredientes() {
        System.out.println("Adicionando queijo e tomate.");
    }
}
