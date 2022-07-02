public class Main {

    public static void main(String[] args) {
        Funcionario funcionario = new Efetivo("Odair","Antunes","123456789",5000.00,1000.00,500.00);
        funcionario.pagamentoSalario();

        funcionario = new Contratado("Marlene","Peixoto","987456321", 100.00,80);
        funcionario.pagamentoSalario();
    }
}
