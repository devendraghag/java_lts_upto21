package com.example.abstractclass;

/** A static factory can hide the concrete subclass from callers. */
public class AbstractClass16FactoryMethodDemo {
    public static void main(String[] args) {
        Transport transport = Transport.create("bike");
        transport.move();
    }

    private abstract static class Transport {
        public abstract void move();

        public static Transport create(String kind) {
            if ("bike".equalsIgnoreCase(kind)) return new Bike();
            throw new IllegalArgumentException("Unknown transport: " + kind);
        }
    }

    private static final class Bike extends Transport {
        @Override public void move() { System.out.println("Pedal forward"); }
    }
}
