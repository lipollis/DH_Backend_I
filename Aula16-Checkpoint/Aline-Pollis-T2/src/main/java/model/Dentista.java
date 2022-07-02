package model;

public class Dentista {
    // ATRIBUTOS
    private Integer idDentista;
    private Integer matricula;
    private String nome;
    private String sobrenome;

    // CONSTRUTOR
    public Dentista(Integer matricula, String nome, String sobrenome) {
        this.matricula = matricula;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Dentista(Integer idDentista, Integer matricula, String nome, String sobrenome) {
        this.idDentista = idDentista;
        this.matricula = matricula;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    // GETTER & SETTER
    public Integer getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(Integer idDentista) {
        this.idDentista = idDentista;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

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

    // toString
    @Override
    public String toString() {
        return "Dentista{" +
               "\nidDentista=" + idDentista +
               ", \nmatricula=" + matricula +
               ", \nnome='" + nome +
               ", \nsobrenome='" + sobrenome +
               "\n}";
    }
}
