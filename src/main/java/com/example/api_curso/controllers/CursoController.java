package com.example.api_curso.controllers;

import com.example.api_curso.Entities.CursoEntity;
import com.example.api_curso.useCase.CreatedCursoUseCase;
import com.example.api_curso.useCase.ProfileCursoUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cursos")

public class CursoController {

    @Autowired
    private CreatedCursoUseCase createdCursoUseCase;

    @Autowired
    private ProfileCursoUseCase profileCursoUseCase;

    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody CursoEntity cursoEntity) {
        try {
            var result = createdCursoUseCase.execute(cursoEntity);
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping()
    public List<CursoEntity> mostrarCursos() {
        return profileCursoUseCase.listarCurso();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable UUID id, HttpServletRequest request) {
        try {
            var curso_profile = profileCursoUseCase.execute(UUID.fromString(id.toString()));

            return ResponseEntity.ok().body(curso_profile);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> put(@PathVariable UUID id, @RequestBody CursoEntity cursoEntity){
        var curso_profile = profileCursoUseCase.execute(UUID.fromString(id.toString()));
        return ResponseEntity.ok("Curso atualizado");
    }
}



