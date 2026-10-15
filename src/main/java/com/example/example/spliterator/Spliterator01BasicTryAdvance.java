package level02_intermediate.jdk8.spliterator;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).

import java.util.List;
import java.util.Spliterator;

/**
 * {@code tryAdvance(Consumer)} is the fundamental pull-based operation every
 * {@code Spliterator} supports: it processes exactly one remaining element and returns
 * {@code true}, or does nothing and returns {@code false} once exhausted. Streams are built on
 * top of repeated {@code tryAdvance} calls (or {@code forEachRemaining} for the whole rest).
 * <p>Output: {@code Visited: Amit}, {@code Visited: Riya}, {@code Visited: Dev}.
 */
public class Spliterator01BasicTryAdvance {
    public static void main(String[] args) {
        List<String> names = List.of("Amit", "Riya", "Dev");
        Spliterator<String> spliterator = names.spliterator();

        boolean hadNext = true;
        while (hadNext) {
            hadNext = spliterator.tryAdvance(name -> System.out.println("Visited: " + name));
        }
    }
}
