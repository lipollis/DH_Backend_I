package com.example.clinicaOdonto.repository.impl;

import com.example.clinicaOdonto.dto.DentistaDTO;
import com.example.clinicaOdonto.model.Dentista;
import com.example.clinicaOdonto.repository.IRepository;

import java.util.HashMap;
import java.util.Map;

public class DentistaRepositoryImpl implements IRepository<Dentista> {
    private static Map<Integer, DentistaDTO> dentistaDTOMap = new HashMap<>();
    private static Integer idGlobal = 1;

    @Override
    public Dentista salvar(Dentista dentista) {
        dentista.setId(idGlobal);
        DentistaDTO dentistaDTO = new DentistaDTO(dentista);
        dentistaDTOMap.put(idGlobal, dentistaDTO);
        idGlobal++;
        return dentista;
    }

    @Override
    public Dentista buscarId(Integer id) {
        Dentista dentista = new Dentista(dentistaDTOMap.get(id));
        return dentista;
    }
}
