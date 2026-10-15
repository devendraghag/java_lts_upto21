package com.example.finalkeyword;

/** Final subclasses are one permitted way to extend a sealed hierarchy (Java 17+). */
public class FinalInSealedHierarchyDemo {
    public static void main(String[] args) {
        Vehicle car = new Car("EV");
        Vehicle truck = new DeliveryTruck("van");
        System.out.println(car.category());
        System.out.println(truck.category());
    }

    private abstract static sealed class Vehicle permits Car, Truck {
        abstract String category();
    }

    private static final class Car extends Vehicle {
        private final String model;
        Car(String model) { this.model = model; }
        @Override String category() { return "Final car: " + model; }
    }

    private static non-sealed class Truck extends Vehicle {
        private final String model;
        Truck(String model) { this.model = model; }
        @Override String category() { return "Truck: " + model; }
    }

    private static final class DeliveryTruck extends Truck {
        DeliveryTruck(String model) { super(model); }
    }
}
