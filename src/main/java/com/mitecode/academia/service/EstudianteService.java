package com.mitecode.academia.service;

import com.mitecode.academia.model.Estudiante;
import com.mitecode.academia.repository.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstudianteService {
    @Autowired
    private final EstudianteRepository estudianteRepository;
    public List<Estudiante> findAllByOrderByEdadDesc() {
        return estudianteRepository.findAll().stream()
                .sorted((e1, e2) -> e2.getEdad().compareTo(e1.getEdad())) // Ordenar de mayor a menor edad
                .collect(Collectors.toList());
    }
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }
}
