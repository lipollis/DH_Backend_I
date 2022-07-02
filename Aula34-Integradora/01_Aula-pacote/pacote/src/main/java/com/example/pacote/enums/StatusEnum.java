package com.example.pacote.enums;


import lombok.Getter;

@Getter //ASSINATURA LOMBOK
public enum StatusEnum {
    A_CAMINHO("Entrega a caminho."), 
    A_COLETAR("Entrega em coleta."), 
    ENTREGUE("Objeto entregue.");

    private final String nomeStatus;

    // CONSTRUTOR PARA PODER PERSONALIZAR A MENSAGEM
    StatusEnum(String nomeStatus) {
        this.nomeStatus = nomeStatus;
    }
}
