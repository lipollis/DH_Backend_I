public class ContaService {

    // MÉTODO QUE VERIFICA A CONTA DO USUÁRIO
    public Conta getConta(String idUsuario){
        System.out.println("Buscando conta...");
        return  new Conta(idUsuario,10000.00);
    }
}
