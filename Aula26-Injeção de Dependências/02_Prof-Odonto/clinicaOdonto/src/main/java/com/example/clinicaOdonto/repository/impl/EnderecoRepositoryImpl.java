package com.example.clinicaOdonto.repository.impl;

import com.example.clinicaOdonto.dto.EnderecoDTO;
import com.example.clinicaOdonto.model.Endereco;
import com.example.clinicaOdonto.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

// CONEXÃO
//ASSINATURA DE CONEXÃO COM O BANCO
@Repository
public class EnderecoRepositoryImpl implements IRepository<Endereco> {
    private static Map<Integer, EnderecoDTO> enderecoMap = new HashMap<>();
    private static Integer idGlobal =1;

    // IMPLEMENTAÇÃO DOS MÉTODOS DA INTERFACE
    @Override
    public Endereco salvar(Endereco endereco) {
        endereco.setId(idGlobal);
        // CONVERSÃO PARA PODER SALVAR
        EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);

        enderecoMap.put(idGlobal,enderecoDTO);
        idGlobal++;

        //enderecoMap.containsKey(enderecoDTO);
        //enderecoMap.forEach();

        return endereco;
    }

    @Override
    public Endereco buscarId(Integer id) {
        // CONVERSÃO
        Endereco endereco = new Endereco(enderecoMap.get(id));
        return endereco;
    }
}
