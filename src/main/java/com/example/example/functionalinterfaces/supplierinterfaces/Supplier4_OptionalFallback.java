package level02_intermediate.jdk8.functionalinterfaces.supplierinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Optional;
import java.util.function.Supplier;

/*
 Supplier4: Used with Optional.orElseGet()
*/
/**
 * Easy: Demonstrates Supplier4 Optional Fallback in the Functional Interfaces / Supplier Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class Supplier4_OptionalFallback {
    public static void main(String[] args) {
        Optional<String> value = Optional.empty();
        String result = value.orElseGet(() -> "Default Value");
        System.out.println(result);
    }
}
