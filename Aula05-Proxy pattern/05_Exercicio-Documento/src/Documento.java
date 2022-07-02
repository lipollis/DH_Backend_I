import java.util.List;

public class Documento {

    // ATRIBUTOS DO OBJETO
    private String id;
    private String url;
    private String conteudo;
    private List<String> usuariosAutorizados;

    // CONSTRUTOR DO OBJETO
    public Documento(String id, String url, List<String> usuariosAutorizados) {
        this.id = id;
        this.url = url;
        this.usuariosAutorizados = usuariosAutorizados;
    }

    // GETTER & SETTER
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getUsuariosAutorizados() {
        return usuariosAutorizados;
    }

    public void setUsuariosAutorizados(List<String> usuariosAutorizados) {
        this.usuariosAutorizados = usuariosAutorizados;
    }
}
