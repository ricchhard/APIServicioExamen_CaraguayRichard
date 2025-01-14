package com.espe.Examen.examen.services;
import com.espe.Examen.examen.models.entities.Examen;

import java.util.List;
import java.util.Optional;

public interface ExamenService {
    List<Examen> findAll();
    Optional<Examen> findById(Long id);
    Examen save(Examen examen);
    void deleteById(Long id);
}
