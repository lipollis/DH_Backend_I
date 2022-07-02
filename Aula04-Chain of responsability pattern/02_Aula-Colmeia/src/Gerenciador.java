// DEFINE A CLASSE MÃE PARA O QUE OS OUTROS VÃO RECEBER (PROTECTED É PARA NÃO OCORRER ALTERAÇÃO)
// DEFINE O FUNCIONAMENTO DAS DEMAIS
public abstract class Gerenciador {

    // VARIÁVEIS SETADAS COM O PRÓXIMO DA LISTA - GET E SET
    protected Gerenciador gerenciadorSeguinte;

    public Gerenciador getGerenciadorSeguinte() {
        return gerenciadorSeguinte;
    }

    public void setGerenciadorSeguinte(Gerenciador gerenciadorSeguinte) {
        this.gerenciadorSeguinte = gerenciadorSeguinte;
    }

    //MÉTODO PARA VERIFICAR SE O QUE CHEGA PERTENCE AO GRUPO - REPETE PARA TODOS
    public abstract void verificar(Mail mail);
}
