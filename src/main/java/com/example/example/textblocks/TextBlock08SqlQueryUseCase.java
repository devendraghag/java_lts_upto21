package level03_advanced.jdk15.textblocks;
// JDK history: Introduction baseline: JDK 15 (the release bucket for this topic).


// Class4: SQL query using Text Blocks
/**
 * Easy: Demonstrates Text Block08 Sql Query Use Case in the Text Blocks topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class TextBlock08SqlQueryUseCase {
    public static void main(String[] args) {

        String sql = """
                SELECT id, name, email
                FROM users
                WHERE active = true
                ORDER BY name
                """;

        System.out.println(sql);
    }
}
