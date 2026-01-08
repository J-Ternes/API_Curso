package com.example.api_curso.Exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Usuário já existe!");
    }
}
