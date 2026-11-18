package com.example.example.sealedclasses;

// JDK history: sealed types became final in Java 17; pattern matching for switch became final in Java 21.

/**
 * Level 13: use a Java 21 pattern switch with a sealed interface.
 *
 * <p>The sealed interface lists every direct variant. Since both permitted records
 * are final, the switch expression can handle the complete set without a default
 * branch. The {@code case null} label handles null explicitly. If another permitted
 * variant is added, this switch must be updated.</p>
 */
public class SealedClasses13PatternSwitch {
    static double area(Shape shape) {
        return switch (shape) {
            case null -> throw new IllegalArgumentException("shape must not be null");
            case Circle circle -> Math.PI * circle.radius() * circle.radius();
            case Rectangle rectangle -> rectangle.width() * rectangle.height();
        };
    }

    public static void main(String[] args) {
        Shape circle = new Circle(2.0);
        Shape rectangle = new Rectangle(3.0, 4.0);

        System.out.printf("Circle area: %.2f%n", area(circle));
        System.out.printf("Rectangle area: %.2f%n", area(rectangle));

        try {
            area(null);
        } catch (IllegalArgumentException exception) {
            System.out.println("Null shape: " + exception.getMessage());
        }
    }

    sealed interface Shape permits Circle, Rectangle {
    }

    record Circle(double radius) implements Shape {
    }

    record Rectangle(double width, double height) implements Shape {
    }
}
