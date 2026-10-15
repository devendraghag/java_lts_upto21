package level03_advanced.jdk16.streamtolist;
// JDK history: Introduction baseline: JDK 16 (the release bucket for this topic).


/*
 * Interview level: Beginner.
 * Feature combination/topic: toList unmodifiable.
 *
 * Notes:
 * - Kept in the JDK16 bucket because the demonstrated feature is available in that LTS line.
 * - This program is intentionally small so the interview concept is easy to explain.
 */
/**
 * Easy: Demonstrates Stream To List03 Unmodifiable in the Stream To List topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class StreamToList03Unmodifiable {
    public static void main(String[] args) throws Exception {
        java.util.List<String> result = java.util.stream.Stream.of("a", "b").toList();
        System.out.println(result);
    }
}