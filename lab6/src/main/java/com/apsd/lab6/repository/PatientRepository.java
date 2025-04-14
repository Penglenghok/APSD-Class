package com.apsd.lab6.repository;

import com.apsd.lab6.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Long> {}