package com.example.clinicaOdonto.service;

import com.example.clinicaOdonto.model.Paciente;

import java.util.Map;

// INTERFACE USANDO O 'T' PARA SERVIR PARA TODOS OS SERVICES
public interface OdontoService<T> {
    T salvar(T t);
    Map<Integer, T> buscarTodos();
    void deletar(Integer id);
    T buscarId(Integer id);
    T atualizar(T t);
}
