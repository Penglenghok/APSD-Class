package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.model.Employee;
import org.example.model.PensionPlan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        loadData();
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JavaTimeModule());


        // Feature 1: Print all employees (including PensionPlan details if any)
        System.out.println("All Employees (sorted by yearly salary descending and last name ascending):");
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getYearlySalary).reversed()
                        .thenComparing(Employee::getLastName))
                .collect(Collectors.toList());
        String allEmployeesJson = mapper.writeValueAsString(sortedEmployees);
        System.out.println(allEmployeesJson);

        // Feature 2: Quarterly Upcoming Enrollees Report
        System.out.println("\nQuarterly Upcoming Enrollees Report (Employees not enrolled and eligible in next quarter):");
        List<Employee> upcomingEnrollees = getUpcomingEnrollees();
        String upcomingJson = mapper.writeValueAsString(upcomingEnrollees);
        System.out.println(upcomingJson);
    }

    // Load the sample Employee and PensionPlan data
    private static void loadData() {
        // Employee 1: Daniel Agar (has PensionPlan)
        employees.add(new Employee(1, "Daniel", "Agar", LocalDate.of(2018, 1, 17), 105945.50,
                new PensionPlan("EX1089", LocalDate.of(2023, 1, 17), 100.00)));
        // Employee 2: Benard Shaw (not enrolled)
        employees.add(new Employee(2, "Benard", "Shaw", LocalDate.of(2022, 9, 3), 197750.00, null));
        // Employee 3: Carly Agar (has PensionPlan)
        employees.add(new Employee(3, "Carly", "Agar", LocalDate.of(2014, 5, 16), 842000.75,
                new PensionPlan("SM2307", LocalDate.of(2019, 11, 4), 1555.50)));
        // Employee 4: Wesley Schneider (not enrolled)
        employees.add(new Employee(4, "Wesley", "Schneider", LocalDate.of(2022, 7, 21), 74500.00, null));
        // Employee 5: Anna Wiltord (not enrolled)
        employees.add(new Employee(5, "Anna", "Wiltord", LocalDate.of(2022, 6, 15), 85750.00, null));
        // Employee 6: Yosef Tesfalem (not enrolled)
        employees.add(new Employee(6, "Yosef", "Tesfalem", LocalDate.of(2022, 10, 31), 100000.00, null));
    }

    // Calculate the next quarter period based on current date
    private static LocalDate[] getNextQuarterPeriod() {
        LocalDate today = LocalDate.now();
        int currentMonth = today.getMonthValue();
        int nextQuarterStartMonth;
        int year = today.getYear();

        if (currentMonth <= 3) {          // Q1: Jan-Mar → next quarter is Q2 (Apr-Jun)
            nextQuarterStartMonth = 4;
        } else if (currentMonth <= 6) {     // Q2: Apr-Jun → next quarter is Q3 (Jul-Sep)
            nextQuarterStartMonth = 7;
        } else if (currentMonth <= 9) {     // Q3: Jul-Sep → next quarter is Q4 (Oct-Dec)
            nextQuarterStartMonth = 10;
        } else {                          // Q4: Oct-Dec → next quarter is Q1 of next year
            nextQuarterStartMonth = 1;
            year += 1;
        }
        LocalDate start = LocalDate.of(year, nextQuarterStartMonth, 1);
        LocalDate end = start.plusMonths(3).minusDays(1);
        return new LocalDate[]{start, end};
    }

    // Generate the Quarterly Upcoming Enrollees Report.
    // Only employees not yet enrolled and whose 3-year eligibility date falls in the next quarter are included.
    private static List<Employee> getUpcomingEnrollees() {
        LocalDate[] quarter = getNextQuarterPeriod();
        LocalDate quarterStart = quarter[0];
        LocalDate quarterEnd = quarter[1];

        return employees.stream()
                .filter(e -> e.getPensionPlan() == null)
                .filter(e -> {
                    // Calculate the date when the employee becomes eligible (after 3 years of employment)
                    LocalDate eligibleDate = e.getEmploymentDate().plusYears(3);
                    return (eligibleDate.isEqual(quarterStart) || eligibleDate.isAfter(quarterStart)) &&
                            (eligibleDate.isEqual(quarterEnd) || eligibleDate.isBefore(quarterEnd));
                })
                .sorted(Comparator.comparing(Employee::getEmploymentDate).reversed())
                .collect(Collectors.toList());
    }
}
