package com.example.clinicaOdonto.service.impl;

import com.example.clinicaOdonto.model.Dentista;
import com.example.clinicaOdonto.repository.impl.DentistaRepositoryImpl;
import com.example.clinicaOdonto.service.OdontoService;
import org.springframework.stereotype.Service;

@Service
public class DentistaServiceImpl implements OdontoService<Dentista> {
    private DentistaRepositoryImpl dentistaRepository;

    public DentistaServiceImpl() {
        this.dentistaRepository = new DentistaRepositoryImpl();
    }

    @Override
    public Dentista salvar(Dentista dentista) {
        return dentistaRepository.salvar(dentista);
    }

    @Override
    public Dentista buscarId(Integer id) {
        return dentistaRepository.buscarId(id);
    }
}
