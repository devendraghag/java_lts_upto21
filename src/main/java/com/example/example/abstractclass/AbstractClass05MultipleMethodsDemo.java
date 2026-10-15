package com.example.abstractclass;

/** A concrete subclass must implement every inherited abstract method. */
public class AbstractClass05MultipleMethodsDemo {
    public static void main(String[] args) {
        Shape shape = new Circle(3);
        System.out.printf("Area %.2f; boundary %.2f%n", shape.area(), shape.boundaryLength());
    }

    private abstract static class Shape {
        public abstract double area();
        public abstract double boundaryLength();
    }

    private static final class Circle extends Shape {
        private final double radius;

        private Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }

        @Override
        public double boundaryLength() {
            return 2 * Math.PI * radius;
        }
    }
}
