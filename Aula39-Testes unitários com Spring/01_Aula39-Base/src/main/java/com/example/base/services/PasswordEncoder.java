package com.example.base.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncoder {

    // assinatura do spring que sinaliza que toda vez que trabalha com bCryptPasswordEncoder, chama o método
    // para o spring não se perder com outras configurações. Toda vez q incriptografa sempre é chamado este método
    // cria um objeto aqui dentro
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
