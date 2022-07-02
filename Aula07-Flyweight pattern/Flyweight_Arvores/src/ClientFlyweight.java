import factory.ArvoreFactory;
import model.Arvore;
import model.enums.Cor;

import java.util.ArrayList;
import java.util.List;

public class ClientFlyweight {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        List<Arvore> floresta = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            if (i < 500000) {
                floresta.add(ArvoreFactory.getArvore(200, 400, Cor.VERDE));
            } else {
                floresta.add(ArvoreFactory.getArvore(500, 300, Cor.VERMELHO));
            }
        }

        System.out.println("Arvores plantadas: " + floresta.size());
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));

    }
}
