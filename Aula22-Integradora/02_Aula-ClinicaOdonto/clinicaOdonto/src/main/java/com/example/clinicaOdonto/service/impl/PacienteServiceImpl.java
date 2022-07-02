package com.example.clinicaOdonto.service.impl;

//import com.example.clinicaOdonto.dao.PacienteDAO;
import com.example.clinicaOdonto.model.Endereco;
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
        // o endereço não está salvo, só o id, precisa-se buscar o id de cada paciente. Para cada paciente salvo,
        // pega-se a chave e o objeto, com eles dentro do paciente pega o idEndereco e salvo o endereco no setEndereco
        // e retorna o pacienteMap
        pacienteMap.forEach((chave,paciente) -> {
            paciente.setEndereco(enderecoService.buscarId(paciente.getIdEndereco()));
        });
        return pacienteMap;
    }

    @Override
    public void deletar(Integer id) {
        enderecoService.deletar(buscarId(id).getIdEndereco());
        pacienteMap.remove(id);
    }


    @Override
    public Paciente buscarId(Integer id) {
        Paciente paciente = new Paciente();
        try{
            // PRIMEIRO BUSCAR O PACIENTE PQ É ONDE ESTÁ O idEndereco
            //PacienteDAO pacienteDAO = pacienteMap.get(id);
            paciente = pacienteMap.get(id);

            // BUSCAR O ENDEREÇO QUE TEM O ID SALVO NO PACIENTE
            //Endereco endereco =enderecoService.buscarId(pacienteDAO.getIdEndereco());
            //Paciente paciente = new Paciente(pacienteDAO, endereco);
            paciente.setEndereco(enderecoService.buscarId(paciente.getIdEndereco()));

        }catch (Exception e){
            return null;
        }

        // a linha anterior (paciente.setEndereco(enderecoService.buscarId(paciente.getIdEndereco()));)
        // é o mesmo que as próximas 4...
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
        enderecoService.atualizar(paciente.getEndereco());
        pacienteMap.put(paciente.getId(), paciente);
        return paciente;
    }
}
