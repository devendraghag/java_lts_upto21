package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Function;

/**
 * Easy: Demonstrates Function1 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Function1 {
    public static void main(String[] args) {

        // Function takes String as input and returns Integer
        Function<String, Integer> lengthFunction = s -> s.length();

        // apply() executes the function
        System.out.println(lengthFunction.apply("Java")); // Output: 4
    }
}
