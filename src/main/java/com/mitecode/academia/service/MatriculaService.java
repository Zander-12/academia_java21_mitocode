package com.mitecode.academia.service;

import com.mitecode.academia.model.Curso;
import com.mitecode.academia.model.DetalleMatricula;
import com.mitecode.academia.model.Matricula;
import com.mitecode.academia.repository.DetalleMatriculaRepository;
import com.mitecode.academia.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MatriculaService {
    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private DetalleMatriculaRepository detalleMatriculaRepository;
    public Matricula registrarMatricula(Matricula matricula) {
        Matricula matriculaGuardada = matriculaRepository.save(matricula);
        List<DetalleMatricula> detalles = matricula.getDetalleMatricula();
        for (DetalleMatricula detalle : detalles) {
            detalle.setMatricula(matriculaGuardada);
            detalleMatriculaRepository.save(detalle);
        }
        return matriculaRepository.save(matricula);
    }
    public Map<String, List<String>> obtenerCursosConEstudiantes() {
        List<Matricula> matriculas = matriculaRepository.findAll();

        return matriculas.stream()
                .flatMap(matricula -> matricula.getDetalleMatricula().stream()
                        .map(detalle -> Map.entry(detalle.getCurso().getNombre(),
                                matricula.getEstudiante().getNombres() + " " + matricula.getEstudiante().getApellidos())))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));
    }
}
