package com.apsd.lab7.repository;

import com.apsd.lab7.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Long> {}
