package Filme;

public interface IGradeDeFilmes {
    public Filme getFilme(String nome) throws FilmeNaoHabilitadoException;
}
