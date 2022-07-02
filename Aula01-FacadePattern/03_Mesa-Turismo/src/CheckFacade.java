public class CheckFacade implements iCheckFacade{
    // ARMAZENAM NAS VARIÁVEIS UMA INSTÂNCIA DE CADA UM
    private VooAPI vooAPI;
    private HotelAPI hotelAPI;

    // CONSTRUTOR QUE CRIA AS INSTÂNCIAS
    public CheckFacade() {
        vooAPI = new VooAPI();
        hotelAPI = new HotelAPI();
    }

    // SIMPLIFICA AS BUSCAS DE VOOS E HOTÉIS
    public void buscar(String dataPartida, String dataRetorno, String origem, String destino) {
        vooAPI.buscarVoos(dataPartida, dataRetorno, origem, destino);
        hotelAPI.buscarHoteis(dataPartida, dataRetorno, destino);
    }
}
