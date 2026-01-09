package com.example.api_curso.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Cria os Getters e Setters
@Builder //Cria os objetos necessários
@NoArgsConstructor
@AllArgsConstructor
public class CursoProfileDTO {

    private String nameCurso;
    private String professor;
    private String category;

}
