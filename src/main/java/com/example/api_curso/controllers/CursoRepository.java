package com.example.api_curso.controllers;

import com.example.api_curso.Entities.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CursoRepository extends JpaRepository<CursoEntity, UUID> {
Optional<CursoEntity> findBynameCurso(String nameCurso);
}
