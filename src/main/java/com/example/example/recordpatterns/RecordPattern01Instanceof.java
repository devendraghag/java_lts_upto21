package level03_advanced.jdk21.recordpatterns;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

/** Level 1: deconstruct a record directly in an instanceof pattern. */
public class RecordPattern01Instanceof {
    record Point(int x, int y) { }

    public static void main(String[] args) {
        Object value = new Point(3, 4);

        if (value instanceof Point(int x, int y)) {
            System.out.println("x=" + x + ", y=" + y); // x=3, y=4
        }
    }
}