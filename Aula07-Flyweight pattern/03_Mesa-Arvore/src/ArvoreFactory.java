import java.util.HashMap;
import java.util.Map;

public class ArvoreFactory {

    // CRIA A VARIÁVEL RESPONSÁVEL PELO CACHE, MEMÓRIA LOCAL
    private static Map<String, Arvore> FLORESTA = new HashMap<>();

    // MÉTODO
    public Arvore getArvore (int altura, int largura, String cor, String tipo){
        String arvoreChave = "Característica da árvore: " + altura + " | "
                + largura + " | " + cor + " | " + tipo;
        System.out.println("..........................");
        System.out.println(arvoreChave);

        // LÓGICA DO FUNCIONAMENTO DO CACHE
        if(!FLORESTA.containsKey(arvoreChave)){
            FLORESTA.put(arvoreChave, new Arvore(altura, largura, cor, tipo));
            System.out.println("Arvore criada!");
            return FLORESTA.get(arvoreChave);
        }
        System.out.println("Recuperando árvore (cache).");
        return FLORESTA.get(arvoreChave);
    }


}
