package level02_intermediate.jdk8.functionalinterfaces.supplierinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BooleanSupplier;

/*
 BooleanSupplier1: Supplies a boolean flag
*/
/**
 * Easy: Demonstrates Boolean Supplier1 Flag in the Functional Interfaces / Supplier Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BooleanSupplier1_Flag {
    public static void main(String[] args) {
        BooleanSupplier isEnabled = () -> true;
        System.out.println(isEnabled.getAsBoolean());
    }
}
