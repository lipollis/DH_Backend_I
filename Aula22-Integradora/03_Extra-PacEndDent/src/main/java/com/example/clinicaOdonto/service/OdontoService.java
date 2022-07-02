package com.example.clinicaOdonto.service;

import com.example.clinicaOdonto.model.Dentista;

import java.util.Map;

// INTERFACE USANDO O 'T' PARA SERVIR PARA TODOS OS SERVICES
public interface OdontoService<T> {
    T salvar(T t);
    T buscarId(Integer id);
    Map<Integer, T> buscarTodos();
    T atualizar(T t);
    void deletar(Integer id);
}
