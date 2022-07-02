import entities.Roupa;
import entities.RoupaFactory;

/*
GRUPO:
- Silvano Araujo
- Dâmares
- Esther Pimentel
- Paula Augusto
- Pedro Brito
- Marcelo Miyoshi
- Matheus Ferraioli
- Aline Pollis
 */

public class Main {
    public static void main(String[] args) {
        Roupa roupa = RoupaFactory.fabricarRoupa("XS", "vestido", true, false);
        Roupa roupa1 = RoupaFactory.fabricarRoupa("M", "vestido", true, false);
        Roupa roupa2 = RoupaFactory.fabricarRoupa("M", "camiseta", true, false);
        Roupa roupa3 = RoupaFactory.fabricarRoupa("G", "camiseta", true, false);
        Roupa roupa4 = RoupaFactory.fabricarRoupa("M", "camiseta", true, false);
        Roupa roupa5 = RoupaFactory.fabricarRoupa("P", "camiseta", true, false);
        Roupa roupa6 = RoupaFactory.fabricarRoupa("M", "camiseta", true, false);
        Roupa roupa7 = RoupaFactory.fabricarRoupa("M", "blusa", true, false);

        RoupaFactory.relatorioFabrica();
        RoupaFactory.listarTamanho("camiseta");
        RoupaFactory.listarTamanho("vestido");
        RoupaFactory.listaModelos();

    }
}