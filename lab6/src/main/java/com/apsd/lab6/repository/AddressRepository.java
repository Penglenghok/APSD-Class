package com.apsd.lab6.repository;

import com.apsd.lab6.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {}
