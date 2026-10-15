package level03_advanced.jdk15.textblocks;
// JDK history: Introduction baseline: JDK 15 (the release bucket for this topic).


/*
 * Interview level: Beginner.
 * Feature combination/topic: JSON text block.
 *
 * Notes:
 * - Kept in the JDK15 bucket because the demonstrated feature is available in that LTS line.
 * - This program is intentionally small so the interview concept is easy to explain.
 */
/**
 * Easy: Demonstrates Text Block10 Json Beginner in the Text Blocks topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class TextBlock10JsonBeginner {
    public static void main(String[] args) throws Exception {
        String json = """
                {"name":"Amit"}
                """;
        System.out.println(json);
    }
}