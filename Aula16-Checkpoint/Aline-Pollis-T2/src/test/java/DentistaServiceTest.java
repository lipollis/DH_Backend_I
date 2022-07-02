import model.Dentista;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.DentistaService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DentistaServiceTest {

    // INSTANCIAR DENTISTA SERVICE
    private static DentistaService dentistaService = new DentistaService();

    // DENTISTA SEJA CRIADO ANTES DE TUDO
    @BeforeAll
    public static void subirDentista(){
        Dentista d01 = dentistaService.salvar(new Dentista(100, "Aline","Pollis"));
        Dentista d02 = dentistaService.salvar(new Dentista(101, "Julia", "Pollis"));
        Dentista d03 = dentistaService.salvar(new Dentista(102, "Miguel", "Pollis"));
        Dentista d04 = dentistaService.salvar(new Dentista(103, "Mariana", "Saidfuss"));
        Dentista d05 = dentistaService.salvar(new Dentista(104, "Bernardo", "Pence"));

    }

    @Test
    public void salvarBuscar(){
        Dentista d06 = dentistaService.salvar(new Dentista(105, "Henrique","Santi"));

        assertNotNull(dentistaService.buscar(d06.getIdDentista()));
    }

    @Test
    public void buscarTodos(){
        List<Dentista> dentistas = dentistaService.buscarTodos();
        // TEM QUE DAR FALSE, NÃO PODE ESTAR VAZIA
        assertFalse(dentistas.isEmpty());
    }

    /*@Test
    public void atualizar(){
        Dentista d05 = dentistaService.atualizar(new Dentista(104, "Julius","Salvatori"));
    }*/

    @Test
    public void excluir(){
        Dentista d06 = dentistaService.salvar(new Dentista(105, "Henrique","Santi"));
        // O RETORNO NÃO PODE DAR VÁZIO
        assertFalse(dentistaService.buscar(d06.getIdDentista()).isEmpty());
        dentistaService.excluir(d06.getIdDentista());
        assertTrue(dentistaService.buscar(d06.getIdDentista()).isEmpty());
    }

}
