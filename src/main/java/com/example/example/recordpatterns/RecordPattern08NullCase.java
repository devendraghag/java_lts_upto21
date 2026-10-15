package level03_advanced.jdk21.recordpatterns;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

/** Level 8: handle null explicitly when switching over values that may be null. */
public class RecordPattern08NullCase {
    record Point(int x, int y) { }

    public static void main(String[] args) {
        Object value = null;

        String result = switch (value) {
            case null -> "No point supplied";
            case Point(int x, int y) -> "Point at (" + x + ", " + y + ")";
            default -> "A different value";
        };
        System.out.println(result); // No point supplied
    }
}