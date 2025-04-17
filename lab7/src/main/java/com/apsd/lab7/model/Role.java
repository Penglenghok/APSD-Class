package com.apsd.lab7.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;  // e.g. "ROLE_OFFICE_MANAGER", "ROLE_ADMIN"

    @ManyToMany(mappedBy = "roles")
    private Set<AppUser> appUsers = new HashSet<>();

    // Constructors, getters, setters
}
