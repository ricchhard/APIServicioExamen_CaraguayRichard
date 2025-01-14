package com.espe.Examen.examen.services;

import com.espe.Examen.examen.models.entities.Examen;
import com.espe.Examen.examen.repositories.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenServiceImpl implements ExamenService {

    @Autowired
    private ExamenRepository repository;

    @Override
    public List<Examen> findAll() {
        return (List<Examen>) repository.findAll();
    }

    @Override
    public Optional<Examen> findById(Long id) {
        return repository.findById(Math.toIntExact(id));
    }

    @Override
    public Examen save(Examen examen) {
        return repository.save(examen);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(Math.toIntExact(id));
    }
}
