package com.example.clinicaOdonto.service;

import com.example.clinicaOdonto.model.Dentista;

import java.util.Map;

// INTERFACE USANDO O 'T' PARA SERVIR PARA TODOS OS SERVICES
public interface OdontoService<T> {
    Dentista salvar(Dentista dentista);
    T buscarId(Integer id);
    Map<Integer, T> buscarTodos();
    Dentista atualizar(Dentista dentista);
    void deletar(Integer id);
}
