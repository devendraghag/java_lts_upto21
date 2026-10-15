package com.example.abstractclass;

/** Shows an intermediate abstract subclass that leaves work to a concrete class. */
public class AbstractClass07AbstractIntermediateSubclassDemo {
    public static void main(String[] args) {
        Shape shape = new Rectangle(4, 6);
        System.out.println("Area: " + shape.area());
        System.out.println("Perimeter: " + shape.perimeter());
    }

    private abstract static class Shape {
        public abstract double area();
        public abstract double perimeter();
    }

    private abstract static class Polygon extends Shape {
        protected final int sideCount;

        protected Polygon(int sideCount) {
            this.sideCount = sideCount;
        }

        public int sideCount() {
            return sideCount;
        }
        // Polygon remains abstract because it does not implement Shape's methods.
    }

    private static final class Rectangle extends Polygon {
        private final double width;
        private final double height;

        private Rectangle(double width, double height) {
            super(4);
            this.width = width;
            this.height = height;
        }

        @Override
        public double area() {
            return width * height;
        }

        @Override
        public double perimeter() {
            return 2 * (width + height);
        }
    }
}
