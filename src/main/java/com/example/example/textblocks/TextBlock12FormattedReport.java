package level03_advanced.jdk15.textblocks;
// JDK history: Introduction baseline: JDK 15 (the release bucket for this topic).


// Class7: Using formatted() with Text Blocks
/**
 * Easy: Demonstrates Text Block12 Formatted Report in the Text Blocks topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class TextBlock12FormattedReport {
    public static void main(String[] args) {

        String name = "Devendra";
        int score = 95;

        String report = """
                Student Report
                Name   : %s
                Score  : %d
                Status : Passed
                """.formatted(name, score);

        System.out.println(report);
    }
}
