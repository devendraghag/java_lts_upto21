package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntFunction;

/**
 * Easy: Demonstrates Int Function12 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class IntFunction12 {

    static IntFunction<String> labeler(String prefix) {
        return i -> prefix + i;
    }

    public static void main(String[] args) {
        System.out.println(labeler("EMP-").apply(101));
    }
}
