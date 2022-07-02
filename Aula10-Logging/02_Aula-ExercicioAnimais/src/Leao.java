import org.apache.log4j.Logger;

public class Leao {

    // IMPORTAÇÃO DO LOG
    private static final Logger logger = Logger.getLogger(Leao.class);

    // ATRIBUTOS
    private String nome;
    private int idade;
    private boolean eAlfa;

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

    public boolean iseAlfa() {
        return eAlfa;
    }

    public void seteAlfa(boolean eAlfa) {
        this.eAlfa = eAlfa;
    }

    // MÉTODO CORRER
    public void correr(){
        logger.info("O leão está correndo");
    }

    // MÉTODO MAIORIDADE
    public void eMaiorQue10() throws Exception {
        if(idade> 10 && iseAlfa()){
            logger.info("O leão " + nome + " é maior de 10 anos e é alfa!");
        }
        if(idade < 0){
            logger.error("A idade não pode ser negativa!");
            throw new Exception();
        }
    }
}
