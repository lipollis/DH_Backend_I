package com.example.clinicaOdonto.service.impl;


import com.example.clinicaOdonto.model.Paciente;
import com.example.clinicaOdonto.repository.impl.PacienteRepositoryImpl;
import com.example.clinicaOdonto.service.OdontoService;
import org.springframework.stereotype.Service;

// ASSINATURA DE SERVIÇO
@Service
public class PacienteServiceImpl implements OdontoService<Paciente> {

    private PacienteRepositoryImpl pacienteRepository;

    public PacienteServiceImpl(){
        this.pacienteRepository = new PacienteRepositoryImpl();
    }

    // IMPLEMENTAÇÃO DOS MÉTODOS DA INTERFACE DO SERVICE
    @Override
    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.salvar(paciente);
    }

    @Override
    public Paciente buscarId(Integer id) {
        return pacienteRepository.buscarId(id);
    }
}
