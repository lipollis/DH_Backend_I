public class Efetivo extends Funcionario {
    // ATRIBUIÇÃO DAS VARIÁVEIS DE FUNCIONÁRIO EFETIVO
    private double salarioBase;
    private double descontos;
    private double bonificacoes;

    // CONSTRUTOR
    public Efetivo(String nome, String sobrenome, String numeroConta, double salarioBase, double descontos, double bonificacoes) {
        super(nome, sobrenome, numeroConta); //o super set as variáveis da classe abstrata
        this.salarioBase = salarioBase;
        this.descontos = descontos;
        this.bonificacoes = bonificacoes;
    }

    // IMPLEMENTAÇÃO DOS MÉTODOS
    @Override
    public double calcularPagamento() {
        return salarioBase + bonificacoes - descontos;
    }

    @Override
    public void imprimirRecibo(double quantia) {
        System.out.println("Foi gerado um recibo impresso na quantia de: " + quantia);
    }
}