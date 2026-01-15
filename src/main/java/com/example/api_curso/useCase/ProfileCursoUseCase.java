package com.example.api_curso.useCase;

import com.example.api_curso.Entities.CursoEntity;
import com.example.api_curso.controllers.CursoRepository;
import com.example.api_curso.dto.CursoProfileDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service //Regra de negócio
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

    public List<CursoEntity> listarCurso(){
        return cursoRepository.findAll();
    }

    @Transactional
    public void atualizarCurso (UUID id, CursoEntity cursoEntityAtualizado){
        var verificaCurso = this.cursoRepository.findById(id).orElseThrow(()->{
            throw new UsernameNotFoundException("Curso not found");
        });
        cursoEntityAtualizado.setId_curso(id);
        cursoRepository.save(cursoEntityAtualizado);
    }
}
