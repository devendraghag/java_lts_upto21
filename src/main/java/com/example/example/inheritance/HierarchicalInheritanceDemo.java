package com.example.inheritance;

import java.util.List;

/** Demonstrates multiple child classes extending the same parent class. */
public class HierarchicalInheritanceDemo {
    public static void main(String[] args) {
        List<Shape> shapes = List.of(new Circle(3), new Rectangle(4, 5));
        for (Shape shape : shapes) {
            System.out.println(shape.description() + ", area=" + shape.area());
        }
    }

    private abstract static class Shape {
        abstract double area();

        String description() {
            return "Shape";
        }
    }

    private static final class Circle extends Shape {
        private final double radius;

        private Circle(double radius) {
            this.radius = radius;
        }

        @Override
        double area() {
            return Math.PI * radius * radius;
        }

        @Override
        String description() {
            return "Circle";
        }
    }

    private static final class Rectangle extends Shape {
        private final double width;
        private final double height;

        private Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        double area() {
            return width * height;
        }

        @Override
        String description() {
            return "Rectangle";
        }
    }
}
