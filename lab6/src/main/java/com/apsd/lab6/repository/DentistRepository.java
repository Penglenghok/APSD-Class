package com.apsd.lab6.repository;

import com.apsd.lab6.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Long> {}
