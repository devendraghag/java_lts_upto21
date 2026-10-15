package com.example.abstractclass;

/** Demonstrates an abstract class with shared state, concrete, and abstract methods. */
public class AbstractClass01BasicsDemo {
    public static void main(String[] args) {
        Vehicle vehicle = new ElectricCar("E-100");
        vehicle.start();
        vehicle.describeEnergySource();
    }

    private abstract static class Vehicle {
        private final String model;

        protected Vehicle(String model) {
            this.model = model;
        }

        public void start() {
            System.out.println(model + " is starting.");
        }

        public abstract void describeEnergySource();
    }

    private static final class ElectricCar extends Vehicle {
        private ElectricCar(String model) {
            super(model);
        }

        @Override
        public void describeEnergySource() {
            System.out.println("It uses an electric battery.");
        }
    }
}
