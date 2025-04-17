package com.apsd.lab7.controller;


import com.apsd.lab7.model.Address;
import com.apsd.lab7.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1")
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }
    @GetMapping("/addresses")
    public List<Address> getAll() {
        return service.findAll();
    }
}
