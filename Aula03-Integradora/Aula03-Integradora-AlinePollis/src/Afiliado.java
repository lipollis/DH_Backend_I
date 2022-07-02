public class Afiliado extends Vendedor{

    // CONSTRUTOR PARA ACESSAR A CLASSE BASE-MÃE (USO DO 'SUPER')
    public Afiliado(String nome){
        super.nome = nome;
        super.PONTOS_POR_VENDA = 15;
    }

    // IMPLEMENTAÇÃO DO MÉTODO ABSTRATO
    @Override
    public int calcularPontos() {
        return this.totalPontos = this.vendas * PONTOS_POR_VENDA;
    }
}
