package dao;

public interface IDao <T>{
    // REFERÊNCIA 'T' PARA QUE A MESMA INTERFACE SE COMUNIQUE DE FORMA GENÉRICA
    // PASSA 't' E RETORNA 'T'
    public T salvar(T t);
    public T buscar();
    public T deletar();
}
