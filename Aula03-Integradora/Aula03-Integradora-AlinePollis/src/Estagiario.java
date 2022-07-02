public class Estagiario extends Vendedor{

    // CONSTRUTOR PARA ACESSAR A CLASSE BASE-MÃE (USO DO 'SUPER')
    public Estagiario(String nome){
        super.nome = nome;
        super.PONTOS_POR_VENDA = 5;
    }

    // IMPLEMENTAÇÃO DO MÉTODO ABSTRATO PARA O CÁLCULO DOS PONTOS
    @Override
    public int calcularPontos() {
        return this.totalPontos = this.vendas * PONTOS_POR_VENDA;
    }

    // MÉTODO PARA CLASSIFICAR A CATEGORIA DE CADA ESTAGIÁRIO CONFORME A PONTUAÇÃO
    @Override
    public String recategorizar() {
        if(this.totalPontos >= 50) {
            return this.categoria = "estagiário experiente";
        } else {
            return this.categoria = "estagiário novato";
        }
    }
}
