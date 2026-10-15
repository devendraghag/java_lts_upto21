package level03_advanced.jdk21.recordpatterns;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

/** Level 2: nest record patterns to deconstruct a record's record components. */
public class RecordPattern02NestedInstanceof {
    record Point(int x, int y) { }
    record Rectangle(Point upperLeft, Point lowerRight) { }

    public static void main(String[] args) {
        Object value = new Rectangle(new Point(1, 2), new Point(8, 6));

        if (value instanceof Rectangle(
                Point(int left, int top), Point(int right, int bottom))) {
            System.out.println("left=" + left + ", top=" + top);
            System.out.println("right=" + right + ", bottom=" + bottom);
        }
    }
}