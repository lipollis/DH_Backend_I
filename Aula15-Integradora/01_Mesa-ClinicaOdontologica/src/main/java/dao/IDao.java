package dao;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {
    // REFERÊNCIA 'T' PARA QUE A MESMA INTERFACE SE COMUNIQUE DE FORMA GENÉRICA
    // PASSA 't' E RETORNA 'T'
    public T salvar(T t);
    public T atualizar(T t);
    public Optional<T> buscar(Integer id); //BUSCAR O END DO PACIENTE
    public List<T> buscarTodos();
    public void excluir(Integer id);

}
