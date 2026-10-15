package level03_advanced.jdk14.switchexpressions;
// JDK history: Switch expressions were previewed in JDK 12 and 13, then finalized in JDK 14.


/*
 * JDK 14 introduction-version bucket feature bucket: switch expressions.
 *
 * Switch expressions became final before JDK 17 and are available in JDK 14 introduction-version bucket.
 * They can return a value and use arrow labels.
 */
/**
 * Easy: Demonstrates Switch Expression02 Demo in the Switch Expressions topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Prove exhaustiveness and describe dominance, null handling, guards, and permitted-type restrictions.
 */
public class SwitchExpression02Demo {
    public static void main(String[] args) {
        String day = "MONDAY";

        String type = switch (day) {
            case "SATURDAY", "SUNDAY" -> "Weekend";
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> "Weekday";
            default -> "Unknown";
        };

        System.out.println(type);
    }
}

