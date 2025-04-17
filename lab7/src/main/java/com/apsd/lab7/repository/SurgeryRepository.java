package com.apsd.lab7.repository;

import com.apsd.lab7.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SurgeryRepository extends JpaRepository<Surgery, Long> {}

