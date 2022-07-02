package Serie;

public class Main_Serie {
    public static void main(String[] args) {
        ISerie buscaSerie = new SerieProxy(new Serie());

        try {
            System.out.println(buscaSerie.getSerie("Vikings"));
        } catch (SerieNaoHabilitadaException exception) {
            System.err.println(exception.getMessage());
        }

        try {
            System.out.println(buscaSerie.getSerie("Round6"));
            System.out.println(buscaSerie.getSerie("Round6"));
            System.out.println(buscaSerie.getSerie("Round6"));
        } catch (SerieNaoHabilitadaException exception) {
            System.err.println(exception.getMessage());
        }

        try {
            System.out.println(buscaSerie.getSerie("Grimm"));
            System.out.println(buscaSerie.getSerie("Grimm"));
            System.out.println(buscaSerie.getSerie("Grimm"));
        } catch (SerieNaoHabilitadaException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
