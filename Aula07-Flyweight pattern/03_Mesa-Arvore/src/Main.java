public class Main {
    public static void main(String[] args) {
        ArvoreFactory floresta = new ArvoreFactory();

        Arvore ornamental = floresta.getArvore(200,400, "Verde", "Ornamental");
        Arvore frutifera = floresta.getArvore(500,300, "Vermelha", "Frutifera");
        Arvore florifera = floresta.getArvore(100,200, "Azul", "Florifera");

        System.out.println("\nAntes do Burnout\n");

        // CHECANDO A MEMÓRIA ANTES DA EXECUÇÃO
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("\nInicio do Burnout\n");

        // TESTANDO A CRIAÇÃO DE 1.000.000 DE ÁRVORES
        for(int i = 0; i < 1000000 ; i++) {
            // DEFINE METADE DAS ÁRVORES COMO VERDES
            if(i < 500000) {
                floresta.getArvore(200,400, "Verde", "Ornamental");
            }
            // DEFINE METADE DAS ÁRVORES COMO VERMELHAS
            floresta.getArvore(200,400, "Vermelha", "Frutifera");
        }
        // CHECA A MEMÓRIA APÓS A EXECUÇÃO
        runtime = Runtime.getRuntime();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Memória utilizada: "
                + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
