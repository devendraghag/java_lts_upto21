package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongFunction;

/**
 * Easy: Demonstrates Long Function11 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class LongFunction11 {

    static void process(long value, LongFunction<String> f) {
        System.out.println(f.apply(value));
    }

    public static void main(String[] args) {
        process(8L, l -> "Square = " + (l * l));
    }
}
