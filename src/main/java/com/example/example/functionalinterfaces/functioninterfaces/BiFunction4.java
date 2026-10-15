package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiFunction;

/**
 * Easy: Demonstrates Bi Function4 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class BiFunction4 {

    static int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {

        // Refers to static method
        BiFunction<Integer, Integer, Integer> mul =
                BiFunction4::multiply;

        System.out.println(mul.apply(5, 4)); // 20
    }
}
