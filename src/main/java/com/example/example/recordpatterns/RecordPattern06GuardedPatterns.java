package level03_advanced.jdk21.recordpatterns;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

/** Level 6: add guards to record patterns to test their extracted components. */
public class RecordPattern06GuardedPatterns {
    record Point(int x, int y) { }

    public static void main(String[] args) {
        Object value = new Point(4, 4);

        String result = switch (value) {
            case Point(int x, int y) when x == y -> "On the diagonal";
            case Point(int x, int y) when x > y -> "Below the diagonal";
            case Point(int x, int y) -> "Above the diagonal";
            default -> "Not a point";
        };
        System.out.println(result); // On the diagonal
    }
}