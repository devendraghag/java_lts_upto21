package level03_advanced.jdk16.streamtolist;

import java.util.List;
import java.util.stream.Stream;

/*
 * JDK 16 introduction-version bucket interview program: Stream.toList mutability trap.
 *
 * Interview point:
 * - Stream.toList returns an unmodifiable list.
 * - Collectors.toList does not guarantee the same contract.
 */
/**
 * Easy: Demonstrates Stream To List05 Unmodifiable Trap in the Stream To List topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class StreamToList05UnmodifiableTrap {
    public static void main(String[] args) {
        List<String> values = Stream.of("A", "B").toList();
        try {
            values.add("C");
            throw new IllegalStateException("Expected unmodifiable list");
        } catch (UnsupportedOperationException exception) {
            System.out.println("Stream.toList is unmodifiable");
        }
    }
}
