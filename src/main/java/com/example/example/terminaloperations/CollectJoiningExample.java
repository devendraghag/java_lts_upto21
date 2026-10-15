package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Demonstrates terminal operation collect() using joining()
 * Shows all common and unique ways to join stream elements
 * Compatible with Java 8 through Java 21
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class CollectJoiningExample {

    public static void main(String[] args) {

        basicJoining();
        joiningWithDelimiter();
        joiningWithPrefixSuffix();
        joiningAfterMapping();
        joiningAfterFiltering();
        joiningUsingStringJoiner();
        joiningUsingReduce();
        joiningUsingToString();
        joiningUnmodifiableSource();
    }

    // ---------------------------------------------------------
    // 1. BASIC joining() – No delimiter
    // ---------------------------------------------------------
    static void basicJoining() {

        String result =
                Arrays.asList("Java", "Streams", "Terminal", "Ops")
                        .stream()
                        .collect(Collectors.joining());

        // Output: JavaStreamsTerminalOps
        System.out.println("1. Basic joining: " + result);
    }

    // ---------------------------------------------------------
    // 2. joining() with delimiter (MOST COMMON)
    // ---------------------------------------------------------
    static void joiningWithDelimiter() {

        String result =
                Arrays.asList("Java", "Streams", "Terminal", "Ops")
                        .stream()
                        .collect(Collectors.joining(" | "));

        // Output: Java | Streams | Terminal | Ops
        System.out.println("2. Joining with delimiter: " + result);
    }

    // ---------------------------------------------------------
    // 3. joining() with delimiter, prefix, and suffix
    // ---------------------------------------------------------
    static void joiningWithPrefixSuffix() {

        String result =
                Arrays.asList("Java", "Streams", "Terminal", "Ops")
                        .stream()
                        .collect(Collectors.joining(
                                ", ",       // delimiter
                                "[ ",       // prefix
                                " ]"        // suffix
                        ));

        // Output: [ Java, Streams, Terminal, Ops ]
        System.out.println("3. Joining with prefix/suffix: " + result);
    }

    // ---------------------------------------------------------
    // 4. joining() AFTER map() (Transform then join)
    // ---------------------------------------------------------
    static void joiningAfterMapping() {

        String result =
                Arrays.asList("java", "streams", "terminal", "ops")
                        .stream()
                        .map(String::toUpperCase) // transform elements
                        .collect(Collectors.joining(" - "));

        // Output: JAVA - STREAMS - TERMINAL - OPS
        System.out.println("4. Map + joining: " + result);
    }

    // ---------------------------------------------------------
    // 5. joining() AFTER filter() (Filter then join)
    // ---------------------------------------------------------
    static void joiningAfterFiltering() {

        String result =
                Arrays.asList("Java", "is", "powerful")
                        .stream()
                        .filter(word -> word.length() > 2)
                        .collect(Collectors.joining(" "));

        // Output: Java powerful
        System.out.println("5. Filter + joining: " + result);
    }

    // ---------------------------------------------------------
    // 6. Using StringJoiner inside collect()
    // ---------------------------------------------------------
    static void joiningUsingStringJoiner() {

        StringJoiner joiner =
                Arrays.asList("Java", "Streams", "Ops")
                        .stream()
                        .collect(
                                () -> new StringJoiner(" | "),
                                StringJoiner::add,
                                StringJoiner::merge
                        );

        // Output: Java | Streams | Ops
        System.out.println("6. StringJoiner collect: " + joiner);
    }

    // ---------------------------------------------------------
    // 7. Using reduce() instead of collect() (NOT preferred)
    // ---------------------------------------------------------
    static void joiningUsingReduce() {

        String result =
                Arrays.asList("Java", "Streams", "Ops")
                        .stream()
                        .reduce((a, b) -> a + " | " + b)
                        .orElse("");

        // Output: Java | Streams | Ops
        System.out.println("7. Reduce-based joining: " + result);
    }

    // ---------------------------------------------------------
    // 8. joining() using List.toString() (Quick & dirty)
    // ---------------------------------------------------------
    static void joiningUsingToString() {

        String result =
                Arrays.asList("Java", "Streams", "Ops")
                        .toString()
                        .replace("[", "")
                        .replace("]", "");

        // Output: Java, Streams, Ops
        System.out.println("8. Using toString(): " + result);
    }

    // ---------------------------------------------------------
    // 9. joining() with a reusable source list
    // ---------------------------------------------------------
    static void joiningUnmodifiableSource() {

        List<String> words = Arrays.asList("Java", "21", "Rocks");

        String result =
                words.stream()
                        .collect(Collectors.joining(" "));

        // Output: Java 21 Rocks
        System.out.println("9. Source list joining: " + result);
    }
}
