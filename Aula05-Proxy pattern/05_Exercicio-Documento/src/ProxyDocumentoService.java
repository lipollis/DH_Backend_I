

import java.sql.Array;
import java.util.*;

public class ProxyDocumentoService implements iDocumentoService {
    private iDocumentoService documentoService;
    // A título de exemplo, utilizaremos uma lista para armazenar os acessos
    private List<Map<String,String>> registroDeUsuarios;

    public ProxyDocumentoService(iDocumentoService documentoService) {
        this.documentoService = documentoService;
        this.registroDeUsuarios = new ArrayList<>();
    }

    @Override
    public Documento buscarDocumento(String url, String email) {

        Documento documento = documentoService.buscarDocumento(url, email);
        if (documento != null) {
            System.out.println("Usuario : " + email + " acessando ao documento com url " + url);
            registroDeUsuarios.add(createSingletonMap(url,email));
            System.out.println("Registro: "+registroDeUsuarios.toString());
        } else {
            System.out.println("O documento não existe ou não tem acesso.");
        }

        return documento;
    }



    private Map<String, String> createSingletonMap(String key, String value) {
        return Collections.singletonMap(key, value);
    }
}