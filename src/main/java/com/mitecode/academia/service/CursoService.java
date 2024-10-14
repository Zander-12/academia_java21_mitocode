package com.mitecode.academia.service;

import com.mitecode.academia.model.Curso;
import com.mitecode.academia.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }
}
