import java.util.Date;

public class Pessoa {
    // ATRIBUTOS DO OBJETO
    private String nome;
    private String sobrenome;
    private String RG;
    private String nomeVacina;
    private Date data;

    // CONSTRUTOR DO OBJETO
    public Pessoa(String nome, String sobrenome, String RG, String nomeVacina, Date data) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.RG = RG;
        this.nomeVacina = nomeVacina;
        this.data = data;
    }

    // GETTER & SETTER
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


    // MÉTODO PARA IMPRIMIR A INFORMAÇÃO SOBRE A VACINAÇÃO
    public Object[] informacoes(){
        Object[] informacao = new Object[3]; // este '3' é um contador
        informacao[0] = RG;
        informacao[1] = data;
        informacao[2] = nomeVacina;
        return informacao;
    }
}
