package level02_intermediate.jdk8.functionalinterfaces.supplierinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Supplier;

/*
 Supplier1: Supplies a constant String value
*/
/**
 * Easy: Demonstrates Supplier1 Simple Value in the Functional Interfaces / Supplier Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class Supplier1_SimpleValue {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello Supplier";
        System.out.println(supplier.get());
    }
}
