public class Main {
    public static void main(String[] args) {
        Cozinheiro cozinheiroVeggie = new CozinheiroVeggie();
        Cozinheiro cozinheiroNoVeggie = new CozinheiroNoVeggie();

        cozinheiroVeggie.fazerPizza();
        cozinheiroNoVeggie.fazerPizza();
    }
}
