package com.example.inheritance;

/** Demonstrates a class inheriting through multiple levels. */
public class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        Manager manager = new Manager("Ravi", 42);
        manager.introduce();
        manager.manageTeam();
    }

    private static class Person {
        protected final String name;

        protected Person(String name) {
            this.name = name;
        }

        protected void introduce() {
            System.out.println("Name: " + name);
        }
    }

    private static class Employee extends Person {
        protected final int employeeId;

        protected Employee(String name, int employeeId) {
            super(name);
            this.employeeId = employeeId;
        }

        @Override
        protected void introduce() {
            super.introduce();
            System.out.println("Employee ID: " + employeeId);
        }
    }

    private static final class Manager extends Employee {
        private Manager(String name, int employeeId) {
            super(name, employeeId);
        }

        private void manageTeam() {
            System.out.println(name + " manages a team.");
        }
    }
}
