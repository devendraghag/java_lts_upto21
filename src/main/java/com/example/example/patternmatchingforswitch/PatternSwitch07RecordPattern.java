package level03_advanced.jdk21.patternmatchingforswitch;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

/** Level 7: deconstruct a record directly in a switch case. */
public class PatternSwitch07RecordPattern {
    record Point(int x, int y) { }

    static String describe(Object value) {
        return switch (value) {
            case Point(int x, int y) -> "Point at (" + x + ", " + y + ")";
            default -> "Not a point";
        };
    }

    public static void main(String[] args) {
        System.out.println(describe(new Point(3, 4)));
        System.out.println(describe("not a point"));
    }
}