package com.apsd.lab7.repository;

import com.apsd.lab7.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppUserRepository extends JpaRepository<AppUser, Long> {}
