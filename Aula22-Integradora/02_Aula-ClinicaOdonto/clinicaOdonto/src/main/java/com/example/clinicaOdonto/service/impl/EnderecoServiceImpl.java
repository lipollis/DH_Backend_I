package com.example.clinicaOdonto.service.impl;

import com.example.clinicaOdonto.model.Endereco;
import com.example.clinicaOdonto.model.Paciente;
import com.example.clinicaOdonto.service.OdontoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service // CONFIGURAÇÃO PARA SERVIÇO
public class EnderecoServiceImpl implements OdontoService<Endereco> {
    // ARMAZENAR OS REGISTROS DOS PACIENTES
    private static Map<Integer, Endereco> enderecoMap = new HashMap<>();

    // VERIFICAÇÃO DO ID
    private static Integer idGlobal = 1;


    // IMPLEMENTAÇÃO DOS MÉTODOS DA INTERFACE
    @Override
    public Endereco salvar(Endereco endereco) {
        endereco.setId(idGlobal); //DÁ O ID PARA O ENDEREÇO
        enderecoMap.put(idGlobal, endereco);
        idGlobal++; //INCREMENTA PARA O PRÓXIMO ENDEREÇO
        return endereco;
    }

    @Override
    public Map<Integer, Endereco> buscarTodos() {
        return null;
    }

    @Override
    public void deletar(Integer id) {
        enderecoMap.remove(id);
    }

    @Override
    public Endereco buscarId(Integer id) {
        return enderecoMap.get(id);
    }

    @Override
    public Endereco atualizar(Endereco endereco) {
        enderecoMap.put(endereco.getId(), endereco);
        return endereco;
    }
}
