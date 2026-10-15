package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiFunction;

/**
 * Easy: Demonstrates Bi Function14 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class BiFunction14 {
    public static void main(String[] args) {

        // Combines two numbers, then squares result
        BiFunction<Integer, Integer, Integer> squareSum =
                (a, b) -> {
                    int sum = a + b;
                    return sum * sum;
                };

        System.out.println(squareSum.apply(2, 3)); // 25
    }
}
