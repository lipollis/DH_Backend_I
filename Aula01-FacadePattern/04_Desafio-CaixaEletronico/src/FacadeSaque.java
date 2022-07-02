public class FacadeSaque implements iFacadeSaque{

    // CHAMADA DOS APIs - SERVIÇOS
    private AuthenticationService authenticationService;
    private ContaService contaService;
    private CaixaService caixaService;

    // CONSTRUTOR PARA INSTANCIAR AS APIs
    public FacadeSaque() {
        this.authenticationService = new AuthenticationService();
        this.contaService = new ContaService();
        this.caixaService = new CaixaService();
    }

    // MÉTODO DE IMPLEMENTAÇÃO COM A INTERFACE
    @Override
    public void sacar(Usuario usuario, double valorSaque) {
        authenticationService.validateUserAndPassword(usuario.getUserID(), usuario.getSenha());
        contaService.getConta(usuario.getUserID(), usuario.getSenha(), usuario.getSaldo());
        caixaService.sacarDinheiro(usuario.getUserID(), usuario.getSenha(),valorSaque, usuario.getSaldo());
    }

}



