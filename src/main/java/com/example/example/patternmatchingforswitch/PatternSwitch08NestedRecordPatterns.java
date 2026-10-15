package level03_advanced.jdk21.patternmatchingforswitch;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

/** Level 8: combine nested record patterns and a guard in a switch case. */
public class PatternSwitch08NestedRecordPatterns {
    record Point(int x, int y) { }
    record Rectangle(Point upperLeft, Point lowerRight) { }

    static String describe(Object value) {
        return switch (value) {
            case Rectangle(
                    Point(var left, var top),
                    Point(var right, var bottom))
                    when right >= left && bottom >= top ->
                    "Rectangle from (" + left + ", " + top + ") to ("
                            + right + ", " + bottom + ")";
            case Rectangle rectangle -> "Rectangle has reversed corners";
            default -> "Not a rectangle";
        };
    }

    public static void main(String[] args) {
        System.out.println(describe(
                new Rectangle(new Point(1, 2), new Point(8, 6))));
        System.out.println(describe(
                new Rectangle(new Point(8, 6), new Point(1, 2))));
    }
}