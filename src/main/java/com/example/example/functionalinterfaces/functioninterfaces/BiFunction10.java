package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiFunction;

/**
 * Easy: Demonstrates Bi Function10 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class BiFunction10 {
    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> sumReducer =
                (a, b) -> a + b;

        int[] arr = {1, 2, 3, 4};
        int result = 0;

        for (int i : arr) {
            result = sumReducer.apply(result, i);
        }

        System.out.println(result); // 10
    }
}
