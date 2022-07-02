package com.dh.clinica.service;

import com.dh.clinica.model.Dentistas;
import com.dh.clinica.repository.impl.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class DentistaService {

    private final DentistaRepository dentistaRepository;

    @Autowired
    public DentistaService(DentistaRepository dentistaRepository) {
        this.dentistaRepository = dentistaRepository;
    }

    public Dentistas registrarDentista(Dentistas dentistas) {
        return dentistaRepository.save(dentistas);

    }

    public void apagar(Integer id) {
        dentistaRepository.deleteById(id);
    }

    public Optional<Dentistas> buscar(Integer id) {
        return dentistaRepository.findById(id);
    }

    public List<Dentistas> buscarTodos() {
        return dentistaRepository.findAll();
    }

    public Dentistas atualizar(Dentistas dentistas) {
        return dentistaRepository.save(dentistas);
    }
}
