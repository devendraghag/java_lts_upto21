package com.example.constructors;

/** Constructor chaining within a class with this(), and to a parent with super(). */
public class ConstructorChainingDemo {
    public static void main(String[] args) {
        System.out.println(new ElectricCar().description());
        System.out.println(new ElectricCar("Roadster", 500).description());
    }

    private static class Vehicle {
        private final String model;

        Vehicle(String model) {
            this.model = model;
            System.out.println("Vehicle constructor: " + model);
        }

        String description() { return "Model: " + model; }
    }

    private static class ElectricCar extends Vehicle {
        private final int rangeKm;

        ElectricCar() {
            this("Unknown", 0); // Delegates to another constructor in this class.
        }

        ElectricCar(String model, int rangeKm) {
            super(model); // Calls the parent constructor; must be the first statement.
            this.rangeKm = rangeKm;
        }

        @Override
        String description() {
            return super.description() + ", range: " + rangeKm + " km";
        }
    }
}
