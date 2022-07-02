import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    // ATRIBUTOS DO OBJETO
    private String nome;
    private LocalDate idade;

    // CONSTRUTOR
    public Pessoa(String nome) {
        this.nome = nome;
    }


    // GETTER & SETTER
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getIdade() {
        return idade;
    }

    public void setIdade(LocalDate idade) {
        this.idade = idade;
    }

    // VALIDAÇÃO COM O NOME E IDADE
    public boolean calcularNome(){
        return this.nome.length() >= 5;
    }

    public boolean maiorDeIdade(){
        return Period.between(this.idade, LocalDate.now()).getYears() > 18;
    }

    // RETORNA UMA LISTA DE PESSOA
    public List<Pessoa> verificarPessoa(List<Pessoa> pessoas){
        List<Pessoa> pessoasMaior = new ArrayList<>();
        pessoas.forEach(pessoa -> { //percorre o array
            if (pessoa.calcularNome() && pessoa.maiorDeIdade())
                pessoasMaior.add(pessoa); //salva no array
        });
        return pessoasMaior;
    }
}
