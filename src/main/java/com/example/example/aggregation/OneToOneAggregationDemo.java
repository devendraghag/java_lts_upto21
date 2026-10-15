package com.example.aggregation;

/** Demonstrates a unidirectional one-to-one aggregation relationship. */
public class OneToOneAggregationDemo {
    public static void main(String[] args) {
        Manager manager = new Manager("Mina"); // Created independently.
        Department department = new Department("Research", manager);

        department.printDetails();
        System.out.println("Manager still exists independently: " + manager.name());
    }

    private record Manager(String name) { }

    private static final class Department {
        private final String name;
        private final Manager manager;

        private Department(String name, Manager manager) {
            this.name = name;
            this.manager = manager;
        }

        private void printDetails() {
            System.out.println(name + " department is managed by " + manager.name());
        }
    }
}
