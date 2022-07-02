package com.example.base.services;

import com.example.base.enums.UserRole;
import com.example.base.persistence.entities.UserEntity;
import com.example.base.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private UserRepository userRepository;

    @Autowired
    // CONSTRUTOR
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // PRIMEIRO MÉTODO QUE O SISTEMA IMPLEMENTA
    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // CONSTRUIDO 2 USERS
        String pass1 = passwordEncoder.encode("password1");
        String pass2 = passwordEncoder.encode("password2");

        userRepository.save(new UserEntity(("Aline", "li", "pollis@dh.com", pass1, UserRole.ADMIN)));
        userRepository.save(new UserEntity(("Thiago", "thiago", "thiago@dh.com", pass1, UserRole.USER)));
    }
}
