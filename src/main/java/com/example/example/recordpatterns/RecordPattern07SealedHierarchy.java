package level03_advanced.jdk21.recordpatterns;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

/** Level 7: record patterns can make a switch exhaustive over a sealed hierarchy. */
public class RecordPattern07SealedHierarchy {
    sealed interface Shape permits Circle, RectangleShape { }
    record Circle(double radius) implements Shape { }
    record RectangleShape(double width, double height) implements Shape { }

    static double area(Shape shape) {
        return switch (shape) {
            case Circle(double radius) -> Math.PI * radius * radius;
            case RectangleShape(double width, double height) -> width * height;
        };
    }

    public static void main(String[] args) {
        System.out.println(area(new Circle(2.0)));
        System.out.println(area(new RectangleShape(3.0, 4.0))); // 12.0
    }
}