package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongFunction;

/**
 * Easy: Demonstrates Long Function5 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class LongFunction5 {
    public static void main(String[] args) {

        // Creates array using size from long
        LongFunction<String[]> arrayCreator =
                size -> new String[(int) size];

        String[] arr = arrayCreator.apply(3L);
        System.out.println(arr.length);
    }
}
