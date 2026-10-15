package level03_advanced.jdk16.records;
// JDK history: Records were previewed in JDK 14 and 15, then finalized in JDK 16.


/**
 * Easy: Demonstrates Record12 Static Member Demo in the Records topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Check canonical-constructor rules, equality semantics, and why record components provide only shallow immutability.
 */
record Circle(double radius) {

    static final double PI = 3.14159;

    static double area(double r) {
        return PI * r * r;
    }
}

public class Record12StaticMemberDemo {
    public static void main(String[] args) {
        System.out.println(Circle.area(5));
    }
}
