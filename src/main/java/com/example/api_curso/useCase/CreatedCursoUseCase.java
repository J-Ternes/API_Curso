package com.example.api_curso.useCase;

import com.example.api_curso.Entities.CursoEntity;
import com.example.api_curso.Exceptions.UserFoundException;
import com.example.api_curso.controllers.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Regra de negócio
public class CreatedCursoUseCase {

    @Autowired
    CursoRepository cursoRepository;

    public CursoEntity execute (CursoEntity cursoEntity){
        this.cursoRepository.findBynameCurso(cursoEntity.getNameCurso())
                .ifPresent((CursoEntity user) ->{
                    throw new UserFoundException();
                });
        return this.cursoRepository.save(cursoEntity);
    }
}
