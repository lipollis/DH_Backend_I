package com.example.base.exceptions;

public class ResourceNotFoundException extends Exception{

    // CONSTRUTOR - TODA A VEZ Q DER ESSE TIPO DE ERRO, ESSE CONSTRUTOR SERÁ CHAMADO
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
