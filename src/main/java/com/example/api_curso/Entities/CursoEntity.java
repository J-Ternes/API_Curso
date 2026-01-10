package com.example.api_curso.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "curso")
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) //Cria o id automaticamente
    private UUID id_curso;

    @NotBlank(message = "Esse campo é obrigatório!")
    private String nameCurso;

    @NotBlank(message = "Esse campo é obrigatório!")
    private String professor;

    @NotBlank(message = "Esse campo é obrigatório!")
    private String category;

    private boolean active;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

}
