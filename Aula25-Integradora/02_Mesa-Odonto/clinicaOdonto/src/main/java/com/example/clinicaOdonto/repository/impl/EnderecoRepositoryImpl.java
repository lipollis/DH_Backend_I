package com.example.clinicaOdonto.repository.impl;

import com.example.clinicaOdonto.dto.EnderecoDTO;
import com.example.clinicaOdonto.model.Endereco;
import com.example.clinicaOdonto.repository.IRepository;

import java.util.HashMap;
import java.util.Map;

// CONEXÃO
public class EnderecoRepositoryImpl implements IRepository<Endereco> {
    private static Map<Integer, EnderecoDTO> enderecoDTOMap = new HashMap<>();
    private static Integer idGlobal =1;

    // IMPLEMENTAÇÃO DOS MÉTODOS DA INTERFACE
    @Override
    public Endereco salvar(Endereco endereco) {
        endereco.setId(idGlobal);
        // CONVERSÃO PARA PODER SALVAR
        EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);

        enderecoDTOMap.put(idGlobal,enderecoDTO);
        idGlobal++;

        //enderecoMap.containsKey(enderecoDTO);
        //enderecoMap.forEach();

        return endereco;
    }

    @Override
    public Endereco buscarId(Integer id) {
        // CONVERSÃO
        Endereco endereco = new Endereco(enderecoDTOMap.get(id));
        return endereco;
    }

    @Override
    public Map<Integer, Endereco> buscarTodos() {
        // ARMAZENAR OS REGISTROS
        Map<Integer, Endereco> enderecoMap = new HashMap<>();

        // RETORNA UMA VIEW DO MAP DURANTE A ITERAÇÃO
        // E ACESSA O REGISTRO E O SET CONVERTE O MAP EM CONJUNTO DE DADOS
        // O GET RECUPERA O VALOR DO MAP
        for (Map.Entry<Integer, EnderecoDTO> entry : enderecoDTOMap.entrySet()) {
            Endereco endereco = new Endereco(entry.getValue());
            enderecoMap.put(endereco.getId(), endereco);
        }
        return enderecoMap;
    }

    @Override
    public Endereco atualizar(Integer id, Endereco endereco) {
        enderecoDTOMap.put(endereco.getId(), new EnderecoDTO(endereco));
        return endereco;
    }

    @Override
    public void deletar(Integer id) {
        enderecoDTOMap.remove(id);
    }
}
