package entities;

import java.util.*;

public class RoupaFactory {
    // CHAVE - VARIÁVEL RESPONSÁVEL PELO CACHE, MEMÓRIA LOCAL
    public static final Map<String, Map<String, Roupa>> MODELOS_ROUPA = new HashMap<>();
    public static int contPedidos=0;

    // MÉTODO RESPONSÁVEL PELO CONTROLE DE CACHE
    public static Roupa fabricarRoupa(String tamanho, String tipo, boolean nova, boolean importada){
        contPedidos++;
        if (!MODELOS_ROUPA.containsKey(tipo)){
            Map<String, Roupa> modelo = new HashMap<>();
            Roupa roupa = new Roupa(tamanho, tipo, nova, importada);
            modelo.put(tamanho, roupa);
            MODELOS_ROUPA.put(tipo, modelo );
        } else {
            if(!MODELOS_ROUPA.get(tipo).containsKey(tamanho)) {
                Roupa roupa = new Roupa(tamanho, tipo, nova, importada);
                MODELOS_ROUPA.get(tipo).put(tamanho, roupa);
            }
        }
        return MODELOS_ROUPA.get(tipo).get(tamanho);
    }

    public static  int getTamanho(){ return MODELOS_ROUPA.size();}

    public static int getContPedidos(){ return contPedidos;}

    public static  void listaModelos() {

        Set<String> busca = MODELOS_ROUPA.keySet();
        for (String key : busca) {
            if (busca != null) {
                System.out.println("Modelos " + key);
                Set<String> busca1 = MODELOS_ROUPA.get(key).keySet();
                for (String key1 : busca1)
                    if (busca1 != null) {
                        System.out.println(" detalhes " + MODELOS_ROUPA.get(key).get(key1));
                    }
            }
        }
    }


    public static void relatorioFabrica(){
        System.out.println("O tamanho da fabrica é " + getTamanho() + " e tem " + contPedidos + " pedidos.");
    }

    public static void listarTamanho(String tipo){
        System.out.println(MODELOS_ROUPA.get(tipo).toString());
    }
}
