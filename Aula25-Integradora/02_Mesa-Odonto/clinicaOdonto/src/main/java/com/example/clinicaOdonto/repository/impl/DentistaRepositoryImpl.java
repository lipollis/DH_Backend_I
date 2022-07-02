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

    @Override
    public Map<Integer, Dentista> buscarTodos() {
        // ARMAZENAR OS REGISTROS
        Map<Integer, Dentista> dentistaMap = new HashMap<>();

        // RETORNA UMA VIEW DO MAP DURANTE A ITERAÇÃO
        // E ACESSA O REGISTRO E O SET CONVERTE O MAP EM CONJUNTO DE DADOS
        // O GET RECUPERA O VALOR DO MAP
        for (Map.Entry<Integer, DentistaDTO> entry : dentistaDTOMap.entrySet()) {
            Dentista dentista = new Dentista(entry.getValue());
            dentistaMap.put(dentista.getId(), dentista);
        }
        return dentistaMap;
    }

    @Override
    public Dentista atualizar(Integer id, Dentista dentista) {
        dentistaDTOMap.put(dentista.getId(), new DentistaDTO(dentista));
        return dentista;
    }

    @Override
    public void deletar(Integer id) {
        dentistaDTOMap.remove(id);
    }
}
