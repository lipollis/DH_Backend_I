public class FacadeImpl implements iFacade {

    // CHAMADA PARA OS SERVIÇOS
    private AuthenticationService authenticationService;
    private CaixaService caixaService;
    private ContaService contaService;

    // CONSTRUTOR
    public FacadeImpl(AuthenticationService authenticationService, CaixaService caixaService, ContaService contaService) {
        this.authenticationService = authenticationService;
        this.caixaService = caixaService;
        this.contaService = contaService;
    }

    // MÉTODO DA INTERFACE
    @Override
    public Boolean sacarDinheiro(String idCliente, String senha, Double saldoASacar) {
        Boolean dinheiroSacado = Boolean.FALSE;
        if (authenticationService.validateUserAndPassword(idCliente, senha)) {
            Conta conta = contaService.getConta(idCliente);
            if (saldoASacar <= conta.getSaldo())
                dinheiroSacado = (caixaService.sacarDinheiro(saldoASacar) != null);

        }
        return dinheiroSacado;
    }
}