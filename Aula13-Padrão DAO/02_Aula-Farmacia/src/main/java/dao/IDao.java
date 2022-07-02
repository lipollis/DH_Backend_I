package dao;

public interface IDao <T>{ // referência T para com a mesma interface comunicar de forma genérica
    //
    public T salvar(T t); //passa t e retorna T
    public T buscar();

}
