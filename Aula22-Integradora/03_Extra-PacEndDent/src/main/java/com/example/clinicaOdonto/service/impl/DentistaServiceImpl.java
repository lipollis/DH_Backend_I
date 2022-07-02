package com.example.clinicaOdonto.service.impl;

import com.example.clinicaOdonto.model.Dentista;
import com.example.clinicaOdonto.service.OdontoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service // CONFIGURAÇÃO PARA SERVIÇO
public class DentistaServiceImpl implements OdontoService<Dentista> {
    // ARMAZENAR OS REGISTROS DOS DENTISTAS
    private static Map<Integer, Dentista> dentistaMap = new HashMap<>();

    // VERIFICAÇÃO DO ID E MATRICULA
    private static Integer idGlobal = 1;
    private static Integer matriculaGerar = 101;



    // IMPLEMENTAÇÃO DOS MÉTODOS
    @Override   // SALVAR
    public Dentista salvar(Dentista dentista) {
        // GERAR ID E MATRICULA EM CADA INCREMENTO
        dentista.setId(idGlobal);
        dentista.setMatricula(matriculaGerar);

        dentistaMap.put(idGlobal, dentista);
        dentistaMap.put(matriculaGerar,dentista);

        idGlobal++;
        matriculaGerar++;
        return dentista;
    }

    @Override   // BUSCAR ID
    public Dentista buscarId(Integer id) {
        Dentista dentista = new Dentista();

        try{    // TRATAMENTO DE ERRO SE NÃO ENCONTRAR REGISTRO NA LISTA
            // BUSCAR O DENTISTA
            dentista = dentistaMap.get(id);

        }catch (Exception e){
            return null;
        }
        return dentistaMap.get(id);
    }

    @Override   // BUSCAR TODOS
    public Map<Integer, Dentista> buscarTodos() {
        return dentistaMap;
    }

    @Override   // ATUALIZAR
    public Dentista atualizar(Dentista dentista) {
        dentistaMap.put(dentista.getId(), dentista);
        return dentista;
    }

    @Override   // DELETAR
    public void deletar(Integer id) {
        dentistaMap.remove(id);
    }
}
