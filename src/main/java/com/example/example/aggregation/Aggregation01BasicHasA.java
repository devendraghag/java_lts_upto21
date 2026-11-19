package com.example.aggregation;

/** A Car has an Engine, but the Engine can exist independently. */
public class Aggregation01BasicHasA {
    public static void main(String[] args) {
        Engine engine = new Engine("Petrol");
        Car car = new Car("City", engine);
        car.start();
        System.out.println("Engine still exists: " + engine.type);
    }

    private static final class Engine {
        private final String type;
        private Engine(String type) { this.type = type; }
    }

    private static final class Car {
        private final String model;
        private final Engine engine;
        private Car(String model, Engine engine) { this.model = model; this.engine = engine; }
        private void start() { System.out.println(model + " starts with " + engine.type + " engine."); }
    }
}
