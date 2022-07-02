public class Main {

    public static void main(String[] args) {
        iFacade caixaFacade = new FacadeImpl(new AuthenticationService(),new CaixaService(), new ContaService());

        Boolean dinheiroEntregue = caixaFacade.sacarDinheiro("40234567","qwerty",1000.00);
        if (!dinheiroEntregue)
            System.out.println("Não pudemos sacar o dinheiro");

    }
}