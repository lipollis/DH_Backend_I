import java.util.HashMap;
import java.util.Map;

public class TrianguloFactory {

    // CHAVE
    public static final Map<String, Triangulo> trianguloMap = new HashMap<>();

    // MÉTODO RESPONSÁVEL PELO CONTROLE DE CACHE
    public static Triangulo obterTriangulo(String cor, int tamanho){
        Triangulo triangulo = trianguloMap.get(cor);
        // VALIDAÇÃO:
        if(triangulo == null){
            triangulo = new Triangulo(cor, tamanho);
            trianguloMap.put(cor, triangulo);
        }
        return triangulo;
    }

}
