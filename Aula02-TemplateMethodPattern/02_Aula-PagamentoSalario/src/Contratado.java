public class Contratado extends Funcionario{
    // ATRIBUIÇÃO DAS VARIÁVEIS DE FUNCIONÁRIO CONTRATADO
    private double valorHora;
    private int horas;

    // CONSTRUTOR
    public Contratado(String nome, String sobrenome, String numeroConta, double valorHora, int horas) {
        super(nome, sobrenome, numeroConta);
        this.valorHora = valorHora;
        this.horas = horas;
    }

    // IMPLEMENTAÇÃO DOS MÉTODOS
    @Override
    public double calcularPagamento() {
        return valorHora * horas;
    }

    @Override
    public void imprimirRecibo(double quantia) {
        System.out.println("Foi gerado um recibo digital na quantia de: " + quantia);
    }

}
