package level03_advanced.jdk21.recordpatterns;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

/** Level 4: use a record pattern as a switch label. */
public class RecordPattern04Switch {
    record Point(int x, int y) { }

    public static void main(String[] args) {
        Object value = new Point(5, 7);

        String description = switch (value) {
            case Point(int x, int y) -> "Point at (" + x + ", " + y + ")";
            default -> "Not a point";
        };
        System.out.println(description); // Point at (5, 7)
    }
}