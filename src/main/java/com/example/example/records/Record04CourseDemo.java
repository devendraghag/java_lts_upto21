package level03_advanced.jdk16.records;
// JDK history: Records were previewed in JDK 14 and 15, then finalized in JDK 16.


/*
 * JDK 16 introduction-version bucket feature bucket: records.
 *
 * Records are compact immutable data carriers. The compiler generates the
 * constructor, accessor methods, equals(), hashCode(), and toString().
 */
/**
 * Easy: Demonstrates Record04 Course Demo in the Records topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Check canonical-constructor rules, equality semantics, and why record components provide only shallow immutability.
 */
record Course(String name, int durationInHours) {
}

public class Record04CourseDemo {
    public static void main(String[] args) {
        Course course = new Course("Java LTS", 40);

        System.out.println(course.name());
        System.out.println(course.durationInHours());
        System.out.println(course);
    }
}

