package com.apsd.lab7.controller;

import com.apsd.lab7.dto.PatientRequestDto;
import com.apsd.lab7.exception.ResourceNotFoundException;
import com.apsd.lab7.model.Address;
import com.apsd.lab7.model.Patient;
import com.apsd.lab7.service.AddressService;
import com.apsd.lab7.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1")
public class PatientController {

    private final PatientService service;
    private final AddressService addressService;


    public PatientController(PatientService service,AddressService addressService) {
        this.service = service;
        this.addressService=addressService;
    }

    // 1) GET all, sorted by name
    @GetMapping("/patients")
    public List<Patient> getAll() {
        return service.findAllSortedByName();
    }

    // 2) GET by id
    @GetMapping("/patients/{id}")
    public Patient getOne(@PathVariable Long id) {
        return service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found: " + id));
    }

    // 3) POST new
    @PostMapping("/patients")
    public ResponseEntity<Patient> create(@RequestBody PatientRequestDto dto) {
        Address addr = addressService.findById(dto.getAddress())
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        System.out.println(addr.getId() + addr.getCity());
        Patient p = new Patient();
        p.setPatientNo(dto.getPatientNo());
        p.setName(dto.getName());
        p.setAddress(addr);

        Patient saved = service.save(p);
        return ResponseEntity.status(201).body(saved);
    }
    // 4) PUT update
    @PutMapping("/patients/{id}")
    public Patient update(@PathVariable Long id, @RequestBody PatientRequestDto dto) {
        return service.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    // you could update patientNo too if you allow it:
                    // existing.setPatientNo(p.getPatientNo());
                    return service.save(existing);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found: " + id));
    }

    // 5) DELETE
    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.existsById(id)) {
            throw new ResourceNotFoundException("Patient not found: " + id);
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // 6) SEARCH by name or patientNo
    @GetMapping("/patients/search/{term}")
    public List<Patient> search(@PathVariable("term") String term) {
        return service.search(term);
    }
}
