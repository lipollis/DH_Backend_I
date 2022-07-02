package com.example.clinicaOdonto.service.impl;

import com.example.clinicaOdonto.model.Paciente;
import com.example.clinicaOdonto.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service // CONFIGURAÇÃO PARA SERVIÇO
public class PacienteServiceImpl implements OdontoService<Paciente> {
    // ARMAZENAR OS REGISTROS DOS PACIENTES
    private static Map<Integer, Paciente> pacienteMap = new HashMap<>();
    //private static Map<Integer, PacienteDAO> pacienteMap = new HashMap<>();

    // VERIFICAÇÃO DO ID
    private static Integer idGlobal = 1;

    // CONEXÃO COM O SERVICE IMPLEMENT DO ENDEREÇO
    @Autowired
    private EnderecoServiceImpl enderecoService;

    // IMPLEMENTAÇÃO DOS MÉTODOS
    @Override   // SALVAR
    public Paciente salvar(Paciente paciente) {
        paciente.setIdEndereco(enderecoService.salvar(paciente.getEndereco()).getId());// SALVA O ENDEREÇO E PASSA O GET
        paciente.setId(idGlobal);
        pacienteMap.put(idGlobal, paciente);
        idGlobal++;
        return paciente;
    }

    @Override   // BUSCAR ID
    public Paciente buscarId(Integer id) {
        Paciente paciente = new Paciente();
        try{
            // PRIMEIRO BUSCAR O PACIENTE PQ É ONDE ESTÁ O idEndereco
            paciente = pacienteMap.get(id);

            // BUSCAR O ENDEREÇO QUE TEM O ID SALVO NO PACIENTE
            paciente.setEndereco(enderecoService.buscarId(paciente.getIdEndereco()));

        }catch (Exception e){
            return null;
        }
        return pacienteMap.get(id);
    }

    @Override   // BUSCAR TODOS
    public Map<Integer, Paciente> buscarTodos() {
        // o endereço não está salvo, só o id, precisa-se buscar o id de cada paciente. Para cada paciente salvo,
        // pega-se a chave e o objeto, com eles dentro do paciente pega o idEndereco e salvo o endereco no setEndereco
        // e retorna o pacienteMap
        pacienteMap.forEach((chave,paciente) -> {
            paciente.setEndereco(enderecoService.buscarId(paciente.getIdEndereco()));
        });
        return pacienteMap;
    }

    @Override   // ATUALIZAR
    public Paciente atualizar(Paciente paciente) {
        enderecoService.atualizar(paciente.getEndereco());
        pacienteMap.put(paciente.getId(), paciente);
        return paciente;
    }

    @Override   // DELETAR
    public void deletar(Integer id) {
        enderecoService.deletar(buscarId(id).getIdEndereco());
        pacienteMap.remove(id);
    }


}
