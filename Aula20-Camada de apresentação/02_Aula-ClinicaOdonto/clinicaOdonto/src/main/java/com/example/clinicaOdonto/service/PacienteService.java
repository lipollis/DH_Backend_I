package com.example.clinicaOdonto.service;

import com.example.clinicaOdonto.model.Paciente;

import java.util.Map;

public interface PacienteService {
    Paciente criarPaciente();
    Map<Integer, Paciente> buscarPacientes();
    void deletar(Integer id);
    Paciente buscarId(Integer id);
    Paciente atualizarPaciente(Integer id, String nome);
}
