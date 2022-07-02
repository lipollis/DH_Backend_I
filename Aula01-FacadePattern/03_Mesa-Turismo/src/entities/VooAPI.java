public class VooAPI {
    // PROCURA DE VOOS DE ACORDO COM UM HORÁRIO PRÉ-ESTABELECIDO
    public void buscarVoos(String dataPartida, String dataRetorno, String origem, String destino){
        System.out.println("=================================");
        System.out.println("Voos encontrados para "+destino+"desde "+origem);
        System.out.println("Data IDA: "+dataPartida+". Data volta: "+dataRetorno);
        System.out.println("........");
        System.out.println("........");
        System.out.println("=================================");
    }
}
