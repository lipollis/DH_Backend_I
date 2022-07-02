public class Main {
    public static void main(String[] args) {
        /*Mofidicar o main para testar a lógica com o template method */
        System.out.println("... ... ... ... ... ... ... ... ... ...");
        Funcionario func1 = new Funcionario("Pedro",2); func1.vender(2);
        Funcionario func2 = new Funcionario("Maria",1); func2.vender(1);

        System.out.println("... ... ... ... ... ... ... ... ... ...");
        Vendedor afi1 = new Afiliado("Ramon"); afi1.vender(4);
        Vendedor afi2 = new Afiliado("Paulo"); afi2.vender(1);
        Vendedor afi3 = new Afiliado("José");

        System.out.println("... ... ... ... ... ... ... ... ... ...");
        Vendedor est1 = new Estagiario("Mariana"); est1.vender(9);
        Vendedor est2 = new Estagiario("Bernardo"); est2.vender(5);

        System.out.println("... ... ... ... ... ... ... ... ... ...");
        func1.addAfiliado(afi1);

        System.out.println("... ... ... ... ... ... ... ... ... ...");
        System.out.println(func1.mostrarCategoria());
        System.out.println(func2.mostrarCategoria());
        System.out.println(afi1.mostrarCategoria());
        System.out.println(est1.mostrarCategoria());
        System.out.println(est2.mostrarCategoria());
    }
}
