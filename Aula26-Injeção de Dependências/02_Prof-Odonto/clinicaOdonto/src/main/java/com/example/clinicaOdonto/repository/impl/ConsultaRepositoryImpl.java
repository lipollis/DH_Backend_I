package com.example.clinicaOdonto.repository.impl;

import com.example.clinicaOdonto.dto.ConsultaDTO;
import com.example.clinicaOdonto.model.Consulta;
import com.example.clinicaOdonto.model.Dentista;
import com.example.clinicaOdonto.model.Paciente;
import com.example.clinicaOdonto.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

//ASSINATURA DE CONEXÃO COM O BANCO
@Repository
public class ConsultaRepositoryImpl implements IRepository<Consulta> {
    // SIMULA O BANCO DE DADOS
    private static Map<Integer, ConsultaDTO> consultaDTOMap = new HashMap<>();
    private static Integer idGlobal =1;

    // INICIAR O DENTISTA E O PACIENTE
    private DentistaRepositoryImpl dentistaRepository;
    private PacienteRepositoryImpl pacienteRepository;

    // CONSTRUTOR PARA O BANCO INICIADO
    public ConsultaRepositoryImpl(){
        this.dentistaRepository = new DentistaRepositoryImpl();
        this.pacienteRepository = new PacienteRepositoryImpl();
    }


    // IMPLEMENTAÇÃO DA INTERFACE
    @Override
    public Consulta salvar(Consulta consulta) {
        // BUSCA SE O PACIENTE EXISTE
        Paciente paciente = pacienteRepository.buscarId(consulta.getPaciente().getId());
        // VERIFICAÇÃO
        if(paciente == null)
            return null;

        // BUSCA SE O DENTISTA EXISTE E FAZ A VERIFICAÇÃO
        Dentista dentista = dentistaRepository.buscarId(consulta.getDentista().getId());
        if(dentista == null)
            return null;

        // COM O idGlobal E RECOLHE TODOS OS DADOS DE PACIENTE E DENTISTA
        consulta.setId(idGlobal);
        consulta.setPaciente(paciente);
        consulta.setDentista(dentista);
        ConsultaDTO consultaDTO = new ConsultaDTO(consulta);
        consultaDTOMap.put(idGlobal, consultaDTO);
        idGlobal++;
        return consulta;
    }

    @Override
    public Consulta buscarId(Integer id) {
        ConsultaDTO consultaDTO = consultaDTOMap.get(id); //tem o id do dentista e paciente
        Paciente paciente = pacienteRepository.buscarId(consultaDTO.getIdPaciente());
        Dentista dentista = dentistaRepository.buscarId(consultaDTO.getIdDentista());
        Consulta consulta = new Consulta(consultaDTO, paciente, dentista);
        return consulta;
    }
}
