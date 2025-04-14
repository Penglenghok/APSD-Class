package com.apsd.lab6.repository;

import com.apsd.lab6.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SurgeryRepository extends JpaRepository<Surgery, Long> {}

