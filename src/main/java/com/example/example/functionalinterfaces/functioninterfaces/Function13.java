package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Function;

/**
 * Easy: Demonstrates Function13 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Function13 {

    // Returns a Function dynamically
    static Function<Integer, Integer> multiplier(int x) {
        return n -> n * x;
    }

    public static void main(String[] args) {

        Function<Integer, Integer> triple = multiplier(3);
        System.out.println(triple.apply(10)); // 30
    }
}
