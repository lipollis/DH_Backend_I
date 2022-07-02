package Filme;

import java.util.ArrayList;
import java.util.List;

public class GradeDeFilmes implements IGradeDeFilmes{

    // ATRIBUTOS DO OBJETO
    private List<Filme> filmes;

    // CONSTRUTOR
    public GradeDeFilmes() {
        this.filmes = new ArrayList<>();
    }

    public GradeDeFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public void addFilme(Filme filme){
        this.filmes.add(filme);
    }

    //
    public List<Filme> getPais(String pais) {
        List<Filme> filmesPais = new ArrayList<>();
        for (Filme filme: filmes) {
            if (filme.getPais().equalsIgnoreCase(pais)){
                filmesPais.add(filme);
            }
        }
        return filmesPais;
    }

    // IMPLEMENTAÇÃO DO MÉTODO
    @Override
    public Filme getFilme(String nome) {
        for (Filme filme: filmes) {
            if (filme.getNome().equalsIgnoreCase(nome)){
                return filme;
            }
        }
        throw new FilmeNaoHabilitadoException("**** Filme não disponível. ****");
    }

}
