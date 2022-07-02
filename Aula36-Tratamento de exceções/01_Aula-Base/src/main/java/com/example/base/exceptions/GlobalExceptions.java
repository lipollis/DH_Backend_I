package com.example.base.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // ASSINATURA
public class GlobalExceptions {

    @ExceptionHandler({ResourceNotFoundException.class})
    // MÉTODO PARA TER ESSE ERRO ^
    public ResponseEntity<String> processarErrorNotFound(ResourceNotFoundException ex){
        // MENSAGEM DE ERRO PERSONALIZADA
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
