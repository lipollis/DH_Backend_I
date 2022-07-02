import org.apache.log4j.Logger;

public class Tigre {

    // IMPORTAÇÃO DO LOG
    private static final Logger logger = Logger.getLogger(Tigre.class);

    // ATRIBUTOS
    private String nome;
    private int idade;

    // GETTER & SETTER
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // MÉTODO CORRER
    public void correr(){
        logger.info("O tigre está correndo");
    }
}
