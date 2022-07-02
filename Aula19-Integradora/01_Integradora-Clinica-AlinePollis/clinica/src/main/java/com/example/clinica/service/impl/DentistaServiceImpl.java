package com.example.clinica.service.impl;

import com.example.clinica.model.Dentista;
import com.example.clinica.service.DentistaService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service //CONFIGURAR COMO SERVICE
public class DentistaServiceImpl implements DentistaService {
    // REGISTRO DE DADOS
    private Dentista dentista1 = new Dentista(100, 500, "Carl", "Fritz");
    private Dentista dentista2 = new Dentista(101, 501, "Marie", "Sauer");


    // IMPLEMENTAÇÃO DO MÉTODO
    @Override
    public List<Dentista> buscarTodos() {
        return Arrays.asList(dentista1, dentista2);
    }

    @Override
    public Dentista buscarId(Integer id) {
        List<Dentista> dentistas = Arrays.asList(dentista1, dentista2);
        return dentistas.stream().filter(dentista -> dentista.getId().equals(id)).findFirst().orElse(null);

    }

}
