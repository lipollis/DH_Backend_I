import java.util.List;

public class ProxyInternet implements iConexaoInternet{

    // O PROXY REALIZA O MESMO QUE O InternetService, MAS LHE
    // ADICIONAMOS UMA LÓGICA EXTRA

    private InternetService internetService;
    private List<String> sitesBloqueados;

    public ProxyInternet (List<String> sitesBloqueados, InternetService internetService){
        this.sitesBloqueados = sitesBloqueados;
        this.internetService = internetService;
    }

    // IMPLEMENTAÇÃO DO MÉTODO
    // O Proxy executa o mesmo que o serviço de internet, mas add uma lógica extra.
    // Neste caso, verificamos se o endereço ao qual queremos nos conectar está na
    // lista de sites bloqueados. Se não estiver, nos conectamos a ele.
    @Override
    public void conectarCom(String url) {
        if(!this.sitesBloqueados.contains(url))
            this.internetService.conectarCom(url);
        else
            System.out.println("Acesso negado.");
    }
}
