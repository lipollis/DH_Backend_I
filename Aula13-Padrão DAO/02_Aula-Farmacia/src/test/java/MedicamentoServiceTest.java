import dao.ConfiguracaoJDBC;
import dao.impl.MedicamentoDaoImpl;
import model.Medicamento;
import org.junit.jupiter.api.Test;
import service.MedicamentoService;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class MedicamentoServiceTest {
    // informação q entra no service - instanciar
    private MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoImpl(new ConfiguracaoJDBC()));

    @Test
    public void guardarMedicamento(){
        Medicamento medicamento = new Medicamento(1234567890,"Ibuprofeno","Labt", 1000, 20.0);
        medicamentoService.salvar(medicamento);
        assertTrue(medicamento.getId() != null);// verifica se a verificação é verdadeira
    }
}
