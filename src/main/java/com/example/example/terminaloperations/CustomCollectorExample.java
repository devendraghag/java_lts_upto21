package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Demonstrates CUSTOM COLLECTORS.
 * Shows how collect() works internally and how to build your own.
 * Compatible with Java 8 through Java 21
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class CustomCollectorExample {

    public static void main(String[] args) {

        basicCustomCollector();
        customCollectorWithDelimiter();
        customCollectorWithCharacteristics();
        customCollectorUsingCollectingAndThen();
        equivalentBuiltInCollector();
        parallelStreamBehavior();
    }

    // ---------------------------------------------------------
    // 1. BASIC Custom Collector (Collector.of - preferred)
    // ---------------------------------------------------------
    static void basicCustomCollector() {

        // Collector<T, A, R>
        // T = stream element type
        // A = mutable accumulator
        // R = final result
        Collector<String, StringBuilder, String> customCollector =
                Collector.of(
                        StringBuilder::new,      // supplier
                        StringBuilder::append,   // accumulator
                        StringBuilder::append,   // combiner
                        StringBuilder::toString  // finisher
                );

        String result =
                java.util.Arrays.asList("J", "a", "v", "a")
                        .stream()
                        .collect(customCollector);

        System.out.println("1. Basic custom collector: " + result);
    }

    // ---------------------------------------------------------
    // 2. Custom Collector with DELIMITER
    // ---------------------------------------------------------
    static void customCollectorWithDelimiter() {

        Collector<String, StringBuilder, String> collector =
                Collector.of(
                        StringBuilder::new,
                        (sb, s) -> {
                            if (sb.length() > 0) {
                                sb.append("-");
                            }
                            sb.append(s);
                        },
                        (sb1, sb2) -> {
                            if (sb1.length() > 0 && sb2.length() > 0) {
                                sb1.append("-");
                            }
                            return sb1.append(sb2);
                        },
                        StringBuilder::toString
                );

        String result =
                java.util.Arrays.asList("Java", "Streams", "API")
                        .stream()
                        .collect(collector);

        System.out.println("2. Custom collector with delimiter: " + result);
    }

    // ---------------------------------------------------------
    // 3. Custom Collector with Characteristics (FULL CONTROL)
    // ---------------------------------------------------------
    static void customCollectorWithCharacteristics() {

        Collector<String, StringBuilder, String> collector =
                new Collector<String, StringBuilder, String>() {

                    @Override
                    public Supplier<StringBuilder> supplier() {
                        return StringBuilder::new;
                    }

                    @Override
                    public BiConsumer<StringBuilder, String> accumulator() {
                        return StringBuilder::append;
                    }

                    @Override
                    public BinaryOperator<StringBuilder> combiner() {
                        return StringBuilder::append;
                    }

                    @Override
                    public Function<StringBuilder, String> finisher() {
                        return StringBuilder::toString;
                    }

                    @Override
                    public Set<Characteristics> characteristics() {
                        // No IDENTITY_FINISH because finisher converts type
                        return EnumSet.noneOf(Characteristics.class);
                    }
                };

        String result =
                java.util.Arrays.asList("C", "u", "s", "t", "o", "m")
                        .stream()
                        .collect(collector);

        System.out.println("3. Collector with characteristics: " + result);
    }

    // ---------------------------------------------------------
    // 4. collectingAndThen() — FIXED VERSION
    // ---------------------------------------------------------
    static void customCollectorUsingCollectingAndThen() {

        String result =
                java.util.Arrays.asList("J", "D", "K", " ", "2", "1")
                        .stream()
                        .collect(Collectors.collectingAndThen(
                                Collector.of(
                                        StringBuilder::new,
                                        StringBuilder::append,
                                        StringBuilder::append
                                ),
                                StringBuilder::toString
                        ));

        System.out.println("4. collectingAndThen(): " + result);
    }

    // ---------------------------------------------------------
    // 5. Equivalent Built-in Collector (BEST PRACTICE)
    // ---------------------------------------------------------
    static void equivalentBuiltInCollector() {

        // Prefer this in real projects
        String result =
                java.util.Arrays.asList("J", "a", "v", "a")
                        .stream()
                        .collect(Collectors.joining());

        System.out.println("5. Built-in joining(): " + result);
    }

    // ---------------------------------------------------------
    // 6. Parallel Stream Behavior
    // ---------------------------------------------------------
    static void parallelStreamBehavior() {

        Collector<String, StringBuilder, String> collector =
                Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString
                );

        // Combiner is heavily used here
        String result =
                java.util.Arrays.asList("P", "a", "r", "a", "l", "l", "e", "l")
                        .parallelStream()
                        .collect(collector);

        System.out.println("6. Parallel stream custom collector: " + result);
    }
}