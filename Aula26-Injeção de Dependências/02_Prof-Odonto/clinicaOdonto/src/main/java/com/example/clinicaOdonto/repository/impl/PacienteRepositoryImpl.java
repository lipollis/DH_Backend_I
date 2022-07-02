package com.example.clinicaOdonto.repository.impl;

import com.example.clinicaOdonto.dto.PacienteDTO;
import com.example.clinicaOdonto.model.Paciente;
import com.example.clinicaOdonto.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

//ASSINATURA DE CONEXÃO COM O BANCO
@Repository
public class PacienteRepositoryImpl implements IRepository<Paciente> {
    private static Map<Integer, PacienteDTO> pacienteDTOMap = new HashMap<>();
    private static Integer idGlobal =1;

    private EnderecoRepositoryImpl enderecoRepository;

    // PRECISA DO CONSTRUTOR PORQUE NÃO TEM ASSINATURA DE SERVICE E AUTOWIRE
    public PacienteRepositoryImpl() {
        this.enderecoRepository = new EnderecoRepositoryImpl();//
    }

    // IMPLEMENTAÇÃO DOS MÉTODOS DA INTERFACE
    @Override
    public Paciente salvar(Paciente paciente) {
        // LÓGICA PARA SALVAR O PACIENTE - PEGA O ID SALVO  EM ENDEREÇO PARA ENTÃO SALVAR DTO DO PACIENTE
        // o usuário precisa do paciente preenchido, então para salvar pego o endereço que chega sem id,
        // salva com o idEndereco, sobreescreve o paciente que chegou do usuário com o id preenchido.
        paciente.setEndereco(enderecoRepository.salvar(paciente.getEndereco()));
        paciente.setId(idGlobal);
        // CONVERSÃO DO PACIENTE PARA PACIENTE DTO:
        PacienteDTO pacienteDTO = new PacienteDTO(paciente);
        // SALVAR:
        pacienteDTOMap.put(idGlobal,pacienteDTO);
        idGlobal++;

        return paciente;
    }

    @Override
    public Paciente buscarId(Integer id) {
        PacienteDTO pacienteDTO = pacienteDTOMap.get(id);
        if(pacienteDTO != null)//
        // RETORNA O PACIENTE BUSCANDO O ID DE ENDEREÇO, SALVO NO DTO - TODOS OS DADOS PREENCHIDOS
            return new Paciente(pacienteDTO, enderecoRepository.buscarId(pacienteDTO.getIdEndereco()));

        return null; //
    }
}
