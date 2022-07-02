package com.example.clinicaOdonto.service.impl;

import com.example.clinicaOdonto.model.Consulta;
import com.example.clinicaOdonto.repository.impl.ConsultaRepositoryImpl;
import com.example.clinicaOdonto.service.OdontoService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ConsultaServiceImpl implements OdontoService<Consulta> {
    private ConsultaRepositoryImpl consultaRepository;

    // CONSTRUTOR
    public ConsultaServiceImpl() {
        this.consultaRepository = new ConsultaRepositoryImpl();
    }

    // IMPLEMENTAR OS MÉTODOS
    @Override
    public Consulta salvar(Consulta consulta) {
        return consultaRepository.salvar(consulta);
    }

    @Override
    public Consulta buscarId(Integer id) {
        return consultaRepository.buscarId(id);
    }

    @Override
    public Map<Integer, Consulta> buscarTodos() {
        return consultaRepository.buscarTodos();
    }

    @Override
    public Consulta atualizar(Integer id, Consulta consulta) {
        return consultaRepository.atualizar(id, consulta);
    }

    @Override
    public void deletar(Integer id) {
        consultaRepository.deletar(id);
    }
}
