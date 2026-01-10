package com.example.api_curso.useCase;

import com.example.api_curso.controllers.CursoRepository;
import com.example.api_curso.dto.CursoProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.UUID;

@Service
public class ProfileCursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoProfileDTO execute (UUID id_curso){

        var curso = this.cursoRepository.findById(id_curso)
               .orElseThrow(()->{
                  throw new UsernameNotFoundException("User not found");
                });

    var cursoDTO =  CursoProfileDTO.builder().nameCurso(curso.getNameCurso()).professor(curso.getProfessor())
            .category(curso.getCategory()).build();

    return cursoDTO;
    }
}
