package factory;

import model.Arvore;
import model.enums.Cor;

import java.util.HashMap;
import java.util.Map;

public class ArvoreFactory {

    private static final Map<String, Arvore> arvores = new HashMap<>();

    public static Arvore getArvore(int altura, int lagura, Cor cor) {
        String key = "key:"+altura+":"+lagura+":"+cor;
        if (!arvores.containsKey(key)) arvores.put(key, new Arvore(altura, lagura, cor));
        return arvores.get(key);
    }
}
