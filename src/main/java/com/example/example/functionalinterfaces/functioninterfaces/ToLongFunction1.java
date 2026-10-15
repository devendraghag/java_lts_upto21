package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.ToLongFunction;

/**
 * Easy: Demonstrates To Long Function1 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class ToLongFunction1 {
    public static void main(String[] args) {
        // Object -> long mapping
        ToLongFunction<String> size = s -> s.length();
        System.out.println(size.applyAsLong("Hello"));
    }
}