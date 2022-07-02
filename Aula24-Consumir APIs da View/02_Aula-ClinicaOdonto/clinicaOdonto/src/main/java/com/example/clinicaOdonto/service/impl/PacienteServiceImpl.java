package com.example.clinicaOdonto.service.impl;


import com.example.clinicaOdonto.model.Paciente;
import com.example.clinicaOdonto.repository.impl.PacienteRepositoryImpl;
import com.example.clinicaOdonto.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// ASSINATURA DE SERVIÇO
@Service
public class PacienteServiceImpl implements OdontoService<Paciente> {

    @Autowired
    private PacienteRepositoryImpl pacienteRepository;

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
