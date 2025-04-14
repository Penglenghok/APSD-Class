package com.apsd.lab6.repository;

import com.apsd.lab6.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppUserRepository extends JpaRepository<AppUser, Long> {}
