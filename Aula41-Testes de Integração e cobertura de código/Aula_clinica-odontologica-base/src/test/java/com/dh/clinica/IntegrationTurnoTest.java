package com.dh.clinica;


import com.dh.clinica.model.Dentistas;
import com.dh.clinica.model.Endereco;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.model.Turno;
import com.dh.clinica.service.DentistaService;
import com.dh.clinica.service.PacienteService;
import com.dh.clinica.service.TurnoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

// ASSINATURA DE CONFIGURAÇÃO
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) //false pq não tem token, e sim, login e senha
public class IntegrationTurnoTest {

    //importação dos serviços usados
    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private DentistaService dentistaService;

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private MockMvc mockMvc;

    // colocar infos na tabela para testar o retorno
    public void carregarDataSet(){
        Endereco endereco = new Endereco("Rua A", "11","BH","MG");
        Paciente paciente = pacienteService.guardar(new Paciente("Thiago", "Bellini", "12345678912",
                                                                 new Date(), endereco));
        Dentistas dentista = dentistaService.registrarDentista(new Dentistas("Pablo","Santos",
                                                                            987456));
        //consulta:
        turnoService.registrarTurno(new Turno(paciente, dentista, new Date()));
    }

    @Test
    public void listarTurnosTest() throws Exception {
        this.carregarDataSet();
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/turnos")
                                                                   .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
        Assert.assertTrue(response.getResponse().getStatus() == 200);

    }

/*    @Test //não implementado no controller
    public void turnoPorIdTest() throws Exception{
        this.carregarDataSet();

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/turnos/{id}","1")
                                                                   .accept(MediaType.APPLICATION_JSON))
                                    .andDo(MockMvcResultHandlers.print())
                                    .andExpect(MockMvcResultMatchers.status().isOk())
                                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                                    .andReturn();
    }*/
}
