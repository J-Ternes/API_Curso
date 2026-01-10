package com.example.api_curso.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //Pede para que o Spring gerencie essas ocnfigurações na hora de rodar a aplicação
public class SecurityConfig {

    @Bean //Sobrescreve o método ja existente dentro da library
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable()); //Desabilita a camada de segurança
        return http.build();
    }
}
