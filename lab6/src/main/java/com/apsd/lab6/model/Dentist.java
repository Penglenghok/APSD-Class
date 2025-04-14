package com.apsd.lab6.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // e.g., "Tony Smith", "Helen Pearson", ...

    // If you want to see which appointments belong to this Dentist:
    // @OneToMany(mappedBy = "dentist")
    // private List<Appointment> appointments = new ArrayList<>();

    // Constructors, getters, setters
}
