import model.Endereco;
import model.Paciente;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.PacienteService;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PacienteServiceTest {
    // INSTANCIAR PACIENTE SERVICE
    private static PacienteService pacienteService = new PacienteService();

    // PACIENTE SEJA CRIADO ANTES DE TUDO
    @BeforeAll
    public static void salvar(){
        Endereco endereco1 = new Endereco("Rua dos Girassóis", "233", "SBC", "SP");
        Paciente p1 = pacienteService.salvar(new Paciente("Aline", "Pollis",
                                                          "123456789", new Date(), endereco1));
        Endereco endereco2 = new Endereco("Rua Dama da noite","100","SBC","SP");
        Paciente p2 = pacienteService.salvar(new Paciente("Mariana", "Saidfuss",
                                                          "123456789",new Date(), endereco2));
    }

    @Test
    public void salvarPacienteEBuscar(){
        Endereco endereco3 = new Endereco("Rua das Hortências", "400", "SBC", "São Paulo");
        Paciente p3 = pacienteService.salvar(new Paciente("Fritz", "Sauer",
                                                          "12309845", new Date(), endereco3));

        assertNotNull(pacienteService.buscar(p3.getId()));
    }

    @Test
    public void excluirPacienteTest(){
        Endereco endereco3 = new Endereco("Rua das Hortências", "400", "SBC", "São Paulo");
        Paciente p3 = pacienteService.salvar(new Paciente("Fritz", "Sauer",
                                                          "12309845", new Date(), endereco3));

        // O RETORNO NÃO PODE DAR VÁZIO
        assertFalse(pacienteService.buscar(p3.getId()).isEmpty());
        pacienteService.excluir(p3.getId());
        assertTrue(pacienteService.buscar(p3.getId()).isEmpty());
    }

    @Test
    public void buscarTodos(){
        List<Paciente> pacientes = pacienteService.buscarTodos();

        // TEM QUE DAR FALSE, NÃO PODE ESTAR VAZIA
        assertFalse(pacientes.isEmpty());
    }
}
