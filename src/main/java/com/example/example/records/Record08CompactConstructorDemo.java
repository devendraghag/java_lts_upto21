package level03_advanced.jdk16.records;
// JDK history: Records were previewed in JDK 14 and 15, then finalized in JDK 16.


/**
 * Easy: Demonstrates Record08 Compact Constructor Demo in the Records topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
record User(String username, int age) {

    // Compact constructor
    // Runs automatically after parameter assignment
    User {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}

public class Record08CompactConstructorDemo {
    public static void main(String[] args) {
        User u = new User("Dev", 30);
        System.out.println(u);
    }
}
