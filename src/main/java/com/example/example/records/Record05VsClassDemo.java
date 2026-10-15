package level03_advanced.jdk16.records;
// JDK history: Records were previewed in JDK 14 and 15, then finalized in JDK 16.


// Record removes boilerplate code
/**
 * Easy: Demonstrates Record05 Vs Class Demo in the Records topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Check canonical-constructor rules, equality semantics, and why record components provide only shallow immutability.
 */
record Point(int x, int y) {}

public class Record05VsClassDemo {
    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        Point p2 = new Point(10, 20);
        // equals is value-based, not reference-based
        System.out.println(p1.equals(p2)); // true
        System.out.println(p1.x());
        System.out.println(p2.y());
    }
}