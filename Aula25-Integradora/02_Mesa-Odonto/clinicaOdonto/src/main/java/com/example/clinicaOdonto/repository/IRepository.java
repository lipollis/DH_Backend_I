package com.example.clinicaOdonto.repository;

import java.util.Map;

public interface IRepository<T> {
    T salvar(T t);
    T buscarId(Integer id);
    Map<Integer, T> buscarTodos();
    T atualizar(Integer id, T t);
    void deletar(Integer id);
}
