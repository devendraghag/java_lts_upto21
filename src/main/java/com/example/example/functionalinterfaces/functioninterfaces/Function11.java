package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Function;

/**
 * Easy: Demonstrates Function11 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Function11 {

    // Tax calculation logic stored as Function
    static Function<Integer, Integer> addTax =
            price -> price + (price * 10 / 100);

    public static void main(String[] args) {
        System.out.println(addTax.apply(100)); // 110
    }
}
