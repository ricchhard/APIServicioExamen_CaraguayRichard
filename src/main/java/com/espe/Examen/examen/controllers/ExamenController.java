package com.espe.Examen.examen.controllers;

import com.espe.Examen.examen.models.entities.Examen;
import com.espe.Examen.examen.services.ExamenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;
import java.util.Date;

@RestController
@RequestMapping("/api/examenes")
public class ExamenController {

    @Autowired
    private ExamenService service;

    // Crear un nuevo examen con validación
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Examen examen) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examen));
    }

    // Listar todos los exámenes
    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.findAll());
    }

    // Buscar un examen por su ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Examen> examenOptional = service.findById(id);
        if (examenOptional.isPresent()) {
            return ResponseEntity.ok(examenOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Modificar un examen por su ID
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@Valid @RequestBody Examen examen, @PathVariable Long id) {
        Optional<Examen> examenOptional = service.findById(id);
        if (examenOptional.isPresent()) {
            Examen examenDB = examenOptional.get();
            examenDB.setNombre(examen.getNombre());
            examenDB.setNota(examen.getNota());
            examenDB.setFecha(examen.getFecha());
            examenDB.setAsignatura(examen.getAsignatura());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDB));
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar un examen por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Examen> examenOptional = service.findById(id);
        if (examenOptional.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
