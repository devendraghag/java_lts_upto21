package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiFunction;

/**
 * Easy: Demonstrates Bi Function2 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class BiFunction2 {
    public static void main(String[] args) {

        // Takes String and Integer, returns formatted String
        BiFunction<String, Integer, String> formatter =
                (name, age) -> name + " is " + age + " years old";

        System.out.println(formatter.apply("Java", 28));
    }
}
