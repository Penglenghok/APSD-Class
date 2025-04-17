package com.apsd.lab7.repository;

import com.apsd.lab7.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByNameContainingIgnoreCaseOrPatientNoContainingIgnoreCase(String name, String patientNo);

}