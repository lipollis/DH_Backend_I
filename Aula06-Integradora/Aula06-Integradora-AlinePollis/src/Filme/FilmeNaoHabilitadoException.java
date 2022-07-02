package Filme;

public class FilmeNaoHabilitadoException extends RuntimeException{
    public FilmeNaoHabilitadoException(String message) {
        super(message);
    }
}
