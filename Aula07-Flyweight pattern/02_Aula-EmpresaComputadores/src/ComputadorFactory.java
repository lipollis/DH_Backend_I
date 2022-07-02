import java.util.HashMap;
import java.util.Map;

public class ComputadorFactory {

    // CRIAR A VARIÁVEL RESPONSÁVEL PELO CACHE, MEMÓRIA LOCAL
    private static Map<String, Computador> COMPUTADORES = new HashMap<>();

    // LÓGICA - MÉTODDO
    public Computador getComputador(int ram, int hd, int id){
        String chave = "key: " + ram + " : " + hd + " : " + id;
        System.out.println(chave);

        // LÓGICA DO FUNCIONAMENTO DO CACHE
        if(!COMPUTADORES.containsKey(chave)){
            COMPUTADORES.put(chave, new Computador(ram, hd, id));
            System.out.println("PC criado");

            return COMPUTADORES.get(chave);
        }

        System.out.println("PC recuperado (do cache)");
        return COMPUTADORES.get(chave);
    }

}
