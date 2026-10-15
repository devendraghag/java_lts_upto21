package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntFunction;

/**
 * Easy: Demonstrates Int Function9 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class IntFunction9 {
    public static void main(String[] args) {

        // Prevents ArrayIndexOutOfBoundsException
        IntFunction<String> safeAccess =
                i -> {
                    try {
                        return "Value at " + i;
                    } catch (Exception e) {
                        return "Invalid";
                    }
                };

        System.out.println(safeAccess.apply(5));
    }
}
