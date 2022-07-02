public class Main {
    public static void main (String[] args){

        // CRIAR O CLIENTE DA FACADE
        iCheckFacade cliente1 = new CheckFacade();
        // SOLICITAR UMA PESQUISA
        cliente1.buscar("02/07/2018", "08/07/2018", "São Paulo", "Cancún");

        // CRIAR O CLIENTE DA FACADE
        iCheckFacade cliente2 = new CheckFacade();
        // SOLICITAR UMA PESQUISA
        cliente2.buscar("02/07/2018", "08/07/2018", "Belo Horizonte", "Quito");
    }
}
