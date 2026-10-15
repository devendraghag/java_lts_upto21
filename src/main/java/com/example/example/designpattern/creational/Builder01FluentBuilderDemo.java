package com.example.designpattern.creational;

// Fluent Builder: named methods make optional constructor values easy to understand.
public class Builder01FluentBuilderDemo {
    static final class Employee {
        private final int id;
        private final String name;
        private final String city;

        private Employee(Builder builder) {
            this.id = builder.id;
            this.name = builder.name;
            this.city = builder.city;
        }

        public String toString() { return id + " " + name + " " + city; }

        static class Builder {
            private final int id;
            private final String name;
            private String city = "Not specified";

            Builder(int id, String name) { this.id = id; this.name = name; }
            Builder city(String city) { this.city = city; return this; }
            Employee build() { return new Employee(this); }
        }
    }

    public static void main(String[] args) {
        Employee employee = new Employee.Builder(7, "Mira").city("Pune").build();
        System.out.println(employee);
    }
}
