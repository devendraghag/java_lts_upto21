package level03_advanced.jdk21.patternmatchingforswitch;
// JDK history: Abstract classes were introduced in JDK 1.0. Records were finalized in JDK 16, sealed types in JDK 17, and pattern matching for switch in JDK 21 after previews in JDK 17 through 20.
/**
 * Demonstrates Sealed Pattern Matching through a small, executable example.
 *
 * <p>Read the type declarations first and then follow {@code main}: the declared reference
 * type determines which members are accessible at compile time, while an overridden instance
 * method is selected from the runtime object type. Any intentionally invalid statement remains
 * commented out so the valid behavior can still be compiled and run.</p>
 */

public class PatternSwitch09SealedHierarchy {
    sealed interface Shape permits Circle, Polygon { }
    record Circle(double radius) implements Shape { }
    sealed abstract static class Polygon implements Shape permits Rectangle { }
    static final class Rectangle extends Polygon {
        final double width;
        final double height;
        Rectangle(double width, double height) { this.width = width; this.height = height; }
    }

    static double area(Shape shape) {
        return switch (shape) {
            case Circle circle -> Math.PI * circle.radius() * circle.radius();
            case Rectangle rectangle -> rectangle.width * rectangle.height;
        };
    }

    public static void main(String[] args) {
        Shape[] shapes = {new Circle(2), new Rectangle(3, 4)};
        for (Shape shape : shapes) {
            System.out.printf("%s area: %.2f%n", shape.getClass().getSimpleName(), area(shape));
        }
        System.out.println("The sealed hierarchy makes the JDK 21 pattern switch exhaustive.");
    }
}
