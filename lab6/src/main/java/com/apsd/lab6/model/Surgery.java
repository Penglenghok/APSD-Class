package com.apsd.lab6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Surgery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surgeryNo;  // e.g. "S15", "S10", ...
    private String surgeryName; // optional for display

    @OneToOne
    private Address address;  // The location of this surgery

    // Constructors, getters, setters
}
