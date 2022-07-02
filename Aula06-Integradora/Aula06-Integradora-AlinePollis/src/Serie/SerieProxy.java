package Serie;

public class SerieProxy implements ISerie{

    // ATRIBUTOS DO OBJETO
    private int qtdeViews;
    private Serie SERIE;

    // CONSTRUTOR
    public SerieProxy(Serie SERIE) {
        this.qtdeViews = qtdeViews;
        this.SERIE = SERIE;
    }

    // IMPLEMENTAÇÃO DO MÉTODO
    @Override
    public String getSerie(String nomeSerie) throws SerieNaoHabilitadaException {

        if(this.qtdeViews < 6) {
            this.qtdeViews++;
            return "\nA série " + this.SERIE.getSerie(nomeSerie) + " está habilitada.";
        } else {
            System.out.println("                     ****");
            throw new SerieNaoHabilitadaException("Limite de vizualizações atingida.");
        }
    }
}
