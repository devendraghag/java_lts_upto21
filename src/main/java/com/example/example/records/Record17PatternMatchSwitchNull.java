package level03_advanced.jdk16.records;
// JDK history: Records were previewed in JDK 14 and 15, then finalized in JDK 16.


/**
 * Easy: Demonstrates Record17 Pattern Match Switch Null in the Records topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Check canonical-constructor rules, equality semantics, and why record components provide only shallow immutability.
 */
record User1(String name) {}

public class Record17PatternMatchSwitchNull {
    public static void main(String[] args) {
        Object obj = null;

        if (obj == null) {
            System.out.println("Null value");
        } else if (obj instanceof User1 user) {
            System.out.println(user.name());
        } else {
            System.out.println("Unknown");
        }
    }
}
