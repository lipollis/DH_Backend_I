public abstract class Funcionario {

    // ATRIBUTOS
    private String nome;
    private String sobrenome;
    private String numeroConta;

    // CONSTRUTOR
    public Funcionario(String nome, String sobrenome, String numeroConta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numeroConta = numeroConta;
    }

    // CÁLCULO DO SALÁRIO
    public void pagamentoSalario(){
        double quantia;
        quantia = calcularPagamento();
        imprimirRecibo(quantia);
        depositar(quantia);
    }

    // MÉTODO ABSTRATO
    protected abstract double calcularPagamento();

    // ORDEM DE CHAMADA DE CADA MÉTODO. É PRECISO ESSES TRÊS MÉTODOS PARA FAZER O CÁLCULO
    public abstract void imprimirRecibo(double quantia);
    public void depositar(double quantia){
        System.out.println("Foi depositado uma quantia de: " + quantia + " na conta " + numeroConta);
    }
}

