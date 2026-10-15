package com.example.streams;

import java.util.HashMap;
import java.util.Map;

/** Streams map entries whose values are instances of a custom class. */
public class Stream09MapCustomValueDemo {
    public static void main(String[] args) {
        Map<Integer, Employee> employeesById = new HashMap<>();
        employeesById.put(103, new Employee("Mira", "Engineering", 105_000, true));
        employeesById.put(101, new Employee("Asha", "Engineering", 92_000, true));
        employeesById.put(102, new Employee("Ben", "Sales", 72_000, false));
        employeesById.put(104, new Employee("Dev", "Sales", 84_000, true));

        // Use entrySet() when a stream needs both the map key (employee ID)
        // and fields from the custom Employee value.
        employeesById.entrySet().stream()
                .filter(entry -> entry.getValue().isActive())
                .filter(entry -> entry.getValue().getSalary() >= 80_000)
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.printf(
                        "ID %d: %s, %s, salary %,d%n",
                        entry.getKey(),
                        entry.getValue().getName(),
                        entry.getValue().getDepartment(),
                        entry.getValue().getSalary()));
    }

    /** A regular custom class used as the map value. */
    private static class Employee {
        private final String name;
        private final String department;
        private final int salary;
        private final boolean active;

        private Employee(String name, String department, int salary, boolean active) {
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.active = active;
        }

        private String getName() {
            return name;
        }

        private String getDepartment() {
            return department;
        }

        private int getSalary() {
            return salary;
        }

        private boolean isActive() {
            return active;
        }
    }
}