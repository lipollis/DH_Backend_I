package Filme;

import IP.IpAdress;

public class GradeFilmesProxy implements IGradeDeFilmes{

    // ATRIBUTOS DO OBJETO
    private IpAdress ipAdress;
    private GradeDeFilmes filmes;

    // CONSTRUTOR DO OBJETO
    public GradeFilmesProxy(IpAdress ipAdress, GradeDeFilmes filmes) {
        this.ipAdress = ipAdress;
        this.filmes = filmes;
    }

    // IMPLEMENTAÇÃO DO MÉTODO
    @Override
    public Filme getFilme(String nome) throws FilmeNaoHabilitadoException {

        if (ipAdress.getIp_aaa() >= 0 && ipAdress.getIp_aaa() < 50) {
            GradeDeFilmes argentina = new GradeDeFilmes(filmes.getPais("Argentina"));
            return argentina.getFilme(nome);

        }
        if (ipAdress.getIp_aaa() >= 50 && ipAdress.getIp_aaa() < 100) {
            GradeDeFilmes brasil = new GradeDeFilmes(filmes.getPais("Brasil"));
            return brasil.getFilme(nome);
        }
        if (ipAdress.getIp_aaa() >= 100 && ipAdress.getIp_aaa() < 150) {
            GradeDeFilmes colombia = new GradeDeFilmes(filmes.getPais("Colombia"));
            return colombia.getFilme(nome);
        }
        throw new FilmeNaoHabilitadoException("Ainda não oferecemos nossos serviços no seu país.");

    }
}
