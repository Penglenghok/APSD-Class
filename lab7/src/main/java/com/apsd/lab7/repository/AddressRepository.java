package com.apsd.lab7.repository;

import com.apsd.lab7.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {}
