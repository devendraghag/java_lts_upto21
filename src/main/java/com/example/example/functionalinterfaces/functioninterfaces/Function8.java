package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Function;

/**
 * Easy: Demonstrates Function8 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Function8 {
    public static void main(String[] args) {

        // Returns Even or Odd based on number
        Function<Integer, String> evenOdd =
                n -> (n % 2 == 0) ? "Even" : "Odd";

        System.out.println(evenOdd.apply(7));
    }
}
