package com.example.interfaces;

/** Demonstrates an abstract interface method, a default method, and an interface constant. */
public class BasicInterfaceDemo {
    private interface Shape {
        String DEFAULT_COLOR = "blue"; // Implicitly public static final.

        double area(); // Implicitly public abstract.

        default void describe() {
            System.out.printf("A %s shape with area %.2f%n", DEFAULT_COLOR, area());
        }
    }

    private static final class Circle implements Shape {
        private final double radius;

        private Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    public static void main(String[] args) {
        Shape shape = new Circle(2.0);
        shape.describe();
        System.out.println("Interface constant: " + Shape.DEFAULT_COLOR);
    }
}
