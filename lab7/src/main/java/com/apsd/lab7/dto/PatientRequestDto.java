package com.apsd.lab7.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientRequestDto {

    private String patientNo;

    private String name;

    private Long address;

}
