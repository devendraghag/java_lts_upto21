package level03_advanced.jdk16.streamtolist;
// JDK history: Introduction baseline: JDK 16 (the release bucket for this topic).


/*
 * Interview level: Intermediate.
 * Feature combination/topic: toList vs collector.
 *
 * Notes:
 * - Kept in the JDK16 bucket because the demonstrated feature is available in that LTS line.
 * - This program is intentionally small so the interview concept is easy to explain.
 */
/**
 * Easy: Demonstrates Stream To List04 Vs Collectors To List in the Stream To List topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class StreamToList04VsCollectorsToList {
    public static void main(String[] args) throws Exception {
        java.util.List<String> list = java.util.stream.Stream.of("A").toList();
        System.out.println(list.getClass().getName());
    }
}