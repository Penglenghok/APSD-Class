package com.apsd.lab6;

import com.apsd.lab6.model.*;
import com.apsd.lab6.repository.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com/apsd/lab6/repository"})

public class Lab6Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab6Application.class, args);
	}
	@Bean
	CommandLineRunner loadData(
			PatientRepository patientRepo,
			DentistRepository dentistRepo,
			SurgeryRepository surgeryRepo,
			AppointmentRepository appointmentRepo,
			AddressRepository addressRepo
	) {
		return args -> {

			// 1) Create Addresses
			Address addr1 = new Address(null,"12 Main St", "London", "L12XY");
			addressRepo.save(addr1);
			// ... add more addresses as needed

			// 2) Create Surgeries
			Surgery s10 = new Surgery(null,"S10", "Surgery #10", addr1);
			Surgery s15 = new Surgery(null,"S15", "Surgery #15", /*maybe another address*/ null);
			surgeryRepo.saveAll(List.of(s10, s15));

			// 3) Create Patients
			Patient p100 = new Patient(null,"P100", "Gillian White", /*maybe an address*/ null);
			Patient p105 = new Patient(null,"P105", "Jill Bell", null);
			// ...
			patientRepo.saveAll(List.of(p100, p105));

			// 4) Create Dentists
			Dentist d1 = new Dentist(null,"Tony Smith");
			Dentist d2 = new Dentist(null,"Helen Pearson");
			dentistRepo.saveAll(List.of(d1, d2));

			// 5) Create sample Appointments
			// E.g. from your sample data table:
			// Tony Smith (dentist) + Gillian White (patient) + date/time + S15
			Appointment appt1 = new Appointment(null,
					LocalDate.of(2013, 9, 12),
					LocalTime.of(10, 0),
					p100, // Gillian White
					d1,   // Tony Smith
					s15
			);
			appointmentRepo.save(appt1);

			// more appointments...
		};
	}
}
