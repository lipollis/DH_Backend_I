package com.example.clinicaOdonto.service.impl;

//import com.example.clinicaOdonto.dao.PacienteDAO;
import com.example.clinicaOdonto.model.Endereco;
import com.example.clinicaOdonto.model.Paciente;
import com.example.clinicaOdonto.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
    @Override
    public Paciente salvar(Paciente paciente) {
        /*PacienteDAO pacienteDAO = new PacienteDAO(paciente);//
        Endereco endereco = enderecoService.salvar(paciente.getEndereco())
        pacienteDAO.setIdEndereco(endereco.getId());
        pacienteDAO.setId(idGlobal);
        pacienteMap.put(idGlobal, pacienteDAO);
        idGlobal++;
        //CONVERSÃO DO PACIENTE PARA DAO
        paciente = new Paciente(pacienteDAO,endereco);
        return paciente;
        */

        //USADO SEM O DAO
        paciente.setIdEndereco(enderecoService.salvar(paciente.getEndereco()).getId());// SALVA O ENDEREÇO E PASSA O GET
        paciente.setId(idGlobal);
        pacienteMap.put(idGlobal, paciente);
        idGlobal++;
        return paciente;
    }

    @Override
    public Map<Integer, Paciente> buscarTodos() {
        return pacienteMap;
    }

    @Override
    public void deletar(Integer id) {
        pacienteMap.remove(id);
    }

    //atualizar:
    @Override
    public Paciente buscarId(Integer id) {
        // PRIMEIRO BUSCAR O PACIENTE PQ É ONDE ESTÁ O idEndereco
        //PacienteDAO pacienteDAO = pacienteMap.get(id);
        Paciente paciente = pacienteMap.get(id);

        // BUSCAR O ENDEREÇO QUE TEM O ID SALVO NO PACIENTE
        //Endereco endereco =enderecoService.buscarId(pacienteDAO.getIdEndereco());
        //Paciente paciente = new Paciente(pacienteDAO, endereco);
        paciente.setEndereco(enderecoService.buscarId(paciente.getIdEndereco()));

        // a linha anterior é o mesmo que as próximas 4...
        /*
        Integer idEndereco = paciente.getIdEndereco();
        Endereco endereco = enderecoService.buscarId(idEndereco);
        paciente.setEndereco(endereco);
        return paciente
        */
        return pacienteMap.get(id);
    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        /*Paciente paciente = buscarId(id);
        paciente.setNome(nome);*/
        return paciente;
    }
}
