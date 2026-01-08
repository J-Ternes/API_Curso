package com.example.api_curso.controllers;

import com.example.api_curso.Entities.CursoEntity;
import com.example.api_curso.useCase.CreatedCursoUseCase;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CursoController {

    @Autowired
    private CreatedCursoUseCase createdCursoUseCase;

    @PostMapping("/cursos")
    public ResponseEntity<Object> create(@Valid @RequestBody CursoEntity cursoEntity){
        try{
            var result = createdCursoUseCase.execute(cursoEntity);
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
