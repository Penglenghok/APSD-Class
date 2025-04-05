package org.example;

import com.google.gson.*;
import org.example.model.Apartment;
import org.example.model.Lease;

import java.lang.reflect.Type;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        Lease lease1 = new Lease(3128874121L, LocalDate.parse("2025-02-01"), LocalDate.parse("2026-02-01"), 1750.50, "Michael Philips");
        Lease lease2 = new Lease(2927458265L, LocalDate.parse("2025-04-02"), LocalDate.parse("2025-10-02"), 1500.00, "Anna Smith");
        Lease lease3 = new Lease(3128874121L, LocalDate.parse("2025-03-01"), LocalDate.parse("2026-03-01"), 2560.75, "Alex Campos");
        Lease lease4 = new Lease(3128874121L, LocalDate.parse("2023-02-01"), LocalDate.parse("2024-02-01"), 1650.55, "Michael Philips");


        Apartment apartment1 = new Apartment("B1102", "The Cameron House", 11L, 790L, 3L);
        Apartment apartment2 = new Apartment("A705", "The Cameron House", 7L, 885L, 4L);
        Apartment apartment3 = new Apartment("C1210", "Pointe Palace", 12L, 1000L, 4L);
        Apartment apartment4 = new Apartment("A1371", "Pointe Palace", 13L, 790L, 4L);

        apartment2.addNewLease(lease1);
        apartment2.addNewLease(lease4);
        apartment1.addNewLease(lease2);
        apartment3.addNewLease(lease3);

        List<Apartment> apartments = new ArrayList<>();
        apartments.add(apartment1);
        apartments.add(apartment2);
        apartments.add(apartment3);
        apartments.add(apartment4);
        printApartment(apartments);
    }

    static void printApartment(List<Apartment> apartments) {
        Collections.sort(apartments, Comparator.comparingLong(Apartment::getSize).reversed().thenComparing(Apartment::getApartmentNo));
        Gson gson = new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
                    @Override
                    public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
                        return new JsonPrimitive(src.toString());
                    }
                })
                .create();
        String json = gson.toJson(apartments);
        System.out.println(json);
        printRevenue(apartments);
    }

    static void printRevenue(List<Apartment> apartments) {
        Double revenue = 0.0;
        for (Apartment apartment : apartments
        ) {
            for (Lease lease: apartment.getLeases()
                 ) {
                revenue+=lease.getMonthlyRentalRate();
            }
        }
        System.out.println("Total Revenu: " + revenue);

    }


}