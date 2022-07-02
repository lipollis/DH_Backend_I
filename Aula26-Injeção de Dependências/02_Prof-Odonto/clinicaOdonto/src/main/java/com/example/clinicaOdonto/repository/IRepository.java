package com.example.clinicaOdonto.repository;

public interface IRepository<T> {
    T salvar(T t);
    T buscarId(Integer id);
}
