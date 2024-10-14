package com.mitecode.academia.controller;

import com.mitecode.academia.model.Estudiante;
import com.mitecode.academia.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@Validated
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;
    @GetMapping("/ordenarxedad")
    public List<Estudiante> listarEstudiantesPorEdadDesc() {
        return estudianteService.findAllByOrderByEdadDesc();
    }
    @PostMapping
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.guardarEstudiante(estudiante);
    }
}
