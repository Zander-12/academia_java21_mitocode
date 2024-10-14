package com.mitecode.academia.controller;

import com.mitecode.academia.model.Curso;
import com.mitecode.academia.model.Matricula;
import com.mitecode.academia.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {
    @Autowired
    private MatriculaService matriculaService;
    @PostMapping
    public Matricula registrarMatricula(@RequestBody Matricula matricula) {
        return matriculaService.registrarMatricula(matricula);
    }
    @GetMapping("/cursos-estudiantes")
    public ResponseEntity<Map<String, List<String>>> obtenerCursosEstudiantes() {
        Map<String, List<String>> cursosEstudiantes = matriculaService.obtenerCursosConEstudiantes();
        return ResponseEntity.ok(cursosEstudiantes);
    }
}
