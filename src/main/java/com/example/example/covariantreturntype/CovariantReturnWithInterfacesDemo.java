package com.example.covariantreturntype;

/** A class may implement an interface method with a narrower reference return type. */
public class CovariantReturnWithInterfacesDemo {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Circle copy = circle.copy(); // No cast is needed when using the concrete class.
        System.out.println("Copied radius: " + copy.radius());

        Shape shape = circle;
        Shape shapeCopy = shape.copy(); // The interface reference exposes Shape as the return type.
        System.out.println("Runtime copy type: " + shapeCopy.getClass().getSimpleName());
    }

    private interface Shape {
        Shape copy();
    }

    private static final class Circle implements Shape {
        private final double radius;

        Circle(double radius) { this.radius = radius; }

        @Override
        public Circle copy() { // Circle is a subtype of Shape.
            return new Circle(radius);
        }

        double radius() { return radius; }
    }
}
