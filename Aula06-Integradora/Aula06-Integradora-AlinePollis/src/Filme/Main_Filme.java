package Filme;

import IP.IpAdress;

import java.util.Arrays;

public class Main_Filme {
    public static void main(String[] args) {
        Filme filme01 = new Filme("A.I. - Inteligência Artificial", "Argentina", "https://www.adorocinema.com/filmes/filme-29280/");
        Filme filme02 = new Filme("Matrix", "Argentina", "https://www.adorocinema.com/filmes/filme-19776/");

        Filme filme03 = new Filme("007 Sem Tempo Para Morrer", "Brasil", "https://www.adorocinema.com/filmes/filme-212358/");
        Filme filme04 = new Filme("As Crônicas de Nárnia", "Brasil", "https://www.adorocinema.com/filmes/filme-47220/");

        Filme filme05 = new Filme("Capitão América", "Colombia", "https://www.adorocinema.com/filmes/filme-136557/");
        Filme filme06 = new Filme("Burlesque", "Colombia", "https://www.adorocinema.com/filmes/filme-48749/");

        GradeDeFilmes stream = new GradeDeFilmes(Arrays.asList(filme01, filme02, filme03, filme04, filme05, filme06));

        IpAdress cliente01 = new IpAdress(25, 100, 100, 100);
        IGradeDeFilmes buscador01 = new GradeFilmesProxy(cliente01,stream);
        try {
            System.out.println("Cliente 01:\n" + buscador01.getFilme("Matrix").getLink() + "\n");
        } catch (FilmeNaoHabilitadoException e) {
            System.out.println("Cliente 01:\n" + e.getMessage() + "\n");
        }

        IpAdress cliente02 = new IpAdress(75, 100, 100, 100);
        IGradeDeFilmes buscador02 = new GradeFilmesProxy(cliente02,stream);
        try {
            System.out.println("Cliente 02:\n" + buscador02.getFilme("Matrix").getLink() + "\n");
        } catch (FilmeNaoHabilitadoException e) {
            System.out.println("Cliente 02:\n" + e.getMessage() + "\n");
        }

        IpAdress cliente03 = new IpAdress(125, 100, 100, 100);
        IGradeDeFilmes buscador03 = new GradeFilmesProxy(cliente03,stream);
        try {
            System.out.println("Cliente 03:\n" + buscador03.getFilme("Matrix").getLink() + "\n");
        } catch (FilmeNaoHabilitadoException e) {
            System.out.println("Cliente 03:\n" + e.getMessage() + "\n");
        }

    }
}
