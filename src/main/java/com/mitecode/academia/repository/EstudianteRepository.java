package com.mitecode.academia.repository;

import com.mitecode.academia.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    List<Estudiante> findAllByOrderByEdadDesc();
}
