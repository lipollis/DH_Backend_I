package com.example.clinicaOdonto.repository.impl;

import com.example.clinicaOdonto.dto.PacienteDTO;
import com.example.clinicaOdonto.model.Endereco;
import com.example.clinicaOdonto.model.Paciente;
import com.example.clinicaOdonto.repository.IRepository;

import java.util.HashMap;
import java.util.Map;

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
        PacienteDTO pacienteDTO = new PacienteDTO(paciente);//*
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

    @Override
    public Map<Integer, Paciente> buscarTodos() {
        // ARMAZENAR OS REGISTROS
        Map<Integer, Paciente> pacienteMap = new HashMap<>();

        // RETORNA UMA VIEW DO MAP (JÁ CONFIGURADO) DURANTE A ITERAÇÃO CONFORME A BUSCA FEITA PELO ID
        // E ACESSA O REGISTRO E O SET CONVERTE O MAP EM CONJUNTO DE DADOS
        // O GET RECUPERA O VALOR DO MAP
        for (Map.Entry<Integer, PacienteDTO> entry : pacienteDTOMap.entrySet()) {
            Paciente paciente = new Paciente(entry.getValue(), enderecoRepository.buscarId(entry.getValue().getIdEndereco()));
            pacienteMap.put(paciente.getId(), paciente);
        }

        return pacienteMap;
    }

    @Override
    public Paciente atualizar(Integer id, Paciente paciente) {
        // BUSCA OS PACIENTES QUE NÃO POSSUEM O ID E RETORNA NULO
        PacienteDTO pacienteDTO = pacienteDTOMap.get(id);
        if(pacienteDTO == null){
            return null;
        }

        // CASO O PACIENTE POSSUA O ID, SET ESSE VALOR, COMPARA COM ENDEREÇO QUAL O CORRESPONDENTE
        paciente.setId(id);
        Endereco endereco = enderecoRepository.buscarId(pacienteDTO.getIdEndereco());
        // ATUALIZA EM PACIENTE O ENDEREÇO
        paciente.getEndereco().setId(endereco.getId());
        enderecoRepository.atualizar(paciente.getEndereco().getId(), paciente.getEndereco());
        PacienteDTO pacienteDTOa = new PacienteDTO(paciente);
        pacienteDTOMap.put(id, pacienteDTOa);
        return paciente;
    }

    @Override
    public void deletar(Integer id) {
        enderecoRepository.deletar(pacienteDTOMap.get(id).getIdEndereco());
        pacienteDTOMap.remove(id);
    }
}
