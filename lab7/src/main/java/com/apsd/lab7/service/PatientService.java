package com.apsd.lab7.service;


import com.apsd.lab7.model.Patient;
import com.apsd.lab7.repository.PatientRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository repo;

    public PatientService(PatientRepository repo) {
        this.repo = repo;
    }

    public List<Patient> findAllSortedByName() {
        return repo.findAll(Sort.by("name").ascending());
    }

    public Optional<Patient> findById(Long id) {
        return repo.findById(id);
    }

    public Patient save(Patient p) {
        return repo.save(p);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repo.existsById(id);
    }

    public List<Patient> search(String term) {
        return repo.findByNameContainingIgnoreCaseOrPatientNoContainingIgnoreCase(term, term);
    }
}
