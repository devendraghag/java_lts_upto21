package level03_advanced.jdk11.predicatenot;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


/*
 * Interview level: Intermediate.
 * Feature combination/topic: Predicate.not with lines.
 *
 * Notes:
 * - Kept in the JDK11 bucket because the demonstrated feature is available in that LTS line.
 * - This program is intentionally small so the interview concept is easy to explain.
 */
/**
 * Easy: Demonstrates Predicate Not03 Lines Combination in the Predicate Not topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class PredicateNot03LinesCombination {
    public static void main(String[] args) throws Exception {
        "A\n \nB".lines().filter(java.util.function.Predicate.not(String::isBlank)).forEach(System.out::println);
    }
}