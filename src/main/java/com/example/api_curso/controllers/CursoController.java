package com.example.api_curso.controllers;

import com.example.api_curso.Entities.CursoEntity;
import com.example.api_curso.useCase.CreatedCursoUseCase;
import com.example.api_curso.useCase.ProfileCursoUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController

public class CursoController {

    @Autowired
    private CreatedCursoUseCase createdCursoUseCase;

    @Autowired
    private ProfileCursoUseCase profileCursoUseCase;

    @PostMapping("/cursos")
    public ResponseEntity<Object> create(@Valid @RequestBody CursoEntity cursoEntity) {
        try {
            var result = createdCursoUseCase.execute(cursoEntity);
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/cursos")
    public ResponseEntity<Object> get(HttpServletRequest request) {
        var id_curso = request.getAttribute("id_curso");
        try {
            var curso_profile = profileCursoUseCase.execute(UUID.fromString(id_curso.toString()));

            return ResponseEntity.ok().body(curso_profile);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
