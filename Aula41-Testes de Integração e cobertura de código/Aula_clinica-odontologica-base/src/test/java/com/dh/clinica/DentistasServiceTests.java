package com.dh.clinica;

import com.dh.clinica.model.Dentistas;
import com.dh.clinica.service.DentistaService;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class DentistasServiceTests {
    @Autowired
    private DentistaService dentistaService;


    public void cargarDataSet() {
        this.dentistaService.registrarDentista(new Dentistas("Santiago", "Paz", 3455647));


    }

    @Test
    public void agregarOdontologo() {
        this.cargarDataSet();
        Dentistas dentistas = dentistaService.registrarDentista(new Dentistas("Juan", "Ramirez", 348971960));
        Assert.assertTrue(dentistas.getId() != null);

    }

    @Test
    public void eliminarOdontologoTest() {
        dentistaService.apagar(1);
        Assert.assertTrue(dentistaService.buscar(1).isEmpty());

    }

    @Test
    public void traerTodos() {
        List<Dentistas> dentistas = dentistaService.buscarTodos();
        Assert.assertTrue(!dentistas.isEmpty());
        Assert.assertTrue(dentistas.size() == 1);
        System.out.println(dentistas);
    }

}
