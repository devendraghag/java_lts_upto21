package level03_advanced.jdk14.switchexpressions;
// JDK history: Switch expressions were previewed in JDK 12 and 13, then finalized in JDK 14.


/*
 * Interview level: Beginner.
 * Feature combination/topic: switch arrow.
 *
 * Notes:
 * - Kept in the JDK14 bucket because the demonstrated feature is available in that LTS line.
 * - This program is intentionally small so the interview concept is easy to explain.
 */
/**
 * Easy: Demonstrates Switch Expression01 Arrow Syntax in the Switch Expressions topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Prove exhaustiveness and describe dominance, null handling, guards, and permitted-type restrictions.
 */
public class SwitchExpression01ArrowSyntax {
    public static void main(String[] args) throws Exception {
        String day = "SAT";
        String type = switch (day) {
            case "SAT", "SUN" -> "weekend";
            default -> "weekday";
        };
        System.out.println(type);
    }
}