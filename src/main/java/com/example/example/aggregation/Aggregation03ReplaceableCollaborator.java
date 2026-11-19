package com.example.aggregation;

/** An aggregation can be supplied and replaced from outside its owner. */
public class Aggregation03ReplaceableCollaborator {
    public static void main(String[] args) {
        Driver driver = new Driver("Mina");
        Car car = new Car("Hatchback", driver);
        car.drive();
        car.assignDriver(new Driver("Noah"));
        car.drive();
        driver.greet(); // The original Driver remains usable independently.
    }

    private static final class Driver {
        private final String name;
        private Driver(String name) { this.name = name; }
        private void greet() { System.out.println("Hello from " + name); }
    }
    private static final class Car {
        private final String model;
        private Driver driver;
        private Car(String model, Driver driver) { this.model = model; this.driver = driver; }
        private void assignDriver(Driver driver) { this.driver = driver; }
        private void drive() { System.out.println(driver.name + " drives the " + model); }
    }
}
