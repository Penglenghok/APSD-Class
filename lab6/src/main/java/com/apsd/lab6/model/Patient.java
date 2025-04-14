package com.apsd.lab6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientNo;   // e.g. "P100", "P105" ...
    private String name;        // e.g. "Gillian White"

    @OneToOne
    private Address address;    // Each patient may have their own Address

    // If you want to see which appointments belong to a Patient:
    // @OneToMany(mappedBy = "patient")
    // private List<Appointment> appointments = new ArrayList<>();

    // Constructors, getters, setters
}
