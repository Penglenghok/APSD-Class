package com.apsd.lab7.service;

import com.apsd.lab7.model.Address;
import com.apsd.lab7.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository repo;

    public AddressService(AddressRepository repo) {
        this.repo = repo;
    }

    public List<Address> findAll(){
        return this.repo.findAll();
    }

    public Optional<Address> findById(Long id){
        return this.repo.findById(id);
    }
}
