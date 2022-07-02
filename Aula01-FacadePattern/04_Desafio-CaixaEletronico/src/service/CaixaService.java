public class CaixaService {

    // MÉTODO PARA SACAR O DINHEIRO
    public void sacarDinheiro(String userID, String senha, double valorSaque, double saldo) {
        if ((userID == "aline") && (senha == "0000")) {
            if (valorSaque > saldo) {
                System.out.println("Não existe saldo suficiente para este saque");
                System.out.println("================================");
            } else {
                double saldoAtual = saldo - valorSaque;
                System.out.println("O saldo atualizado da conta é " + saldoAtual);
                System.out.println("================================");
            }
        } else {
            System.out.println("Usuário ou senha não identificado.");
            System.out.println("================================");
        }

    }
}