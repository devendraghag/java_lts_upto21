package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiFunction;

/**
 * Easy: Demonstrates Bi Function6 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class BiFunction6 {
    public static void main(String[] args) {

        // Price + tax percentage
        BiFunction<Integer, Integer, Integer> addTax =
                (price, tax) -> price + (price * tax / 100);

        System.out.println(addTax.apply(1000, 18));
    }
}
