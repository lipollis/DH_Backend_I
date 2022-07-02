package com.example.clinicaOdonto.service;


public interface OdontoService<T> {
    T salvar(T t);
    T buscarId(Integer id);
}
