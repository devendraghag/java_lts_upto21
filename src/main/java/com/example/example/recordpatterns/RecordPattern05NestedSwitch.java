package level03_advanced.jdk21.recordpatterns;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

/** Level 5: combine switch with nested record patterns. */
public class RecordPattern05NestedSwitch {
    record Point(int x, int y) { }
    record Rectangle(Point upperLeft, Point lowerRight) { }

    public static void main(String[] args) {
        Object value = new Rectangle(new Point(1, 2), new Point(8, 6));

        String description = switch (value) {
            case Rectangle(Point(int left, int top), Point(int right, int bottom)) ->
                    "Rectangle corners: (" + left + ", " + top + ") and ("
                            + right + ", " + bottom + ")";
            default -> "Not a rectangle";
        };
        System.out.println(description);
    }
}