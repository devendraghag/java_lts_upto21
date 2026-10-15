package level03_advanced.jdk17.sealedclasses;
// JDK history: Sealed classes and interfaces were previewed in JDK 15 and 16, then finalized in JDK 17.

/** Level 1: a sealed class lists the classes allowed to extend it. */
public class SealedClasses01BasicClass {
    sealed static class Shape permits Circle, Rectangle { }

    static final class Circle extends Shape {
        private final double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        double radius() {
            return radius;
        }
    }

    static final class Rectangle extends Shape {
        private final double width;
        private final double height;

        Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        double area() {
            return width * height;
        }
    }

    public static void main(String[] args) {
        Shape circle = new Circle(2.0);
        Shape rectangle = new Rectangle(3.0, 4.0);

        System.out.println(circle.getClass().getSimpleName());
        System.out.println(rectangle.getClass().getSimpleName());
    }
}