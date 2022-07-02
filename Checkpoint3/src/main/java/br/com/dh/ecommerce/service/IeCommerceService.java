package br.com.dh.ecommerce.service;

import java.util.List;

public interface IeCommerceService<T> {
    // T salvar(T t);
    T buscarId(Integer id);
    List<T> buscarTodos();
    // T atualizar(T t);
    // void deletar(Integer id);
}
