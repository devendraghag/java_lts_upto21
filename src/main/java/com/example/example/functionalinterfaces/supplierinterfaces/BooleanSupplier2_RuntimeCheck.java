package level02_intermediate.jdk8.functionalinterfaces.supplierinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BooleanSupplier;

/*
 BooleanSupplier2: Runtime condition check
*/
/**
 * Easy: Demonstrates Boolean Supplier2 Runtime Check in the Functional Interfaces / Supplier Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BooleanSupplier2_RuntimeCheck {
    public static void main(String[] args) {
        BooleanSupplier isMemoryAvailable =
                () -> Runtime.getRuntime().freeMemory() > 1000;
        System.out.println(isMemoryAvailable.getAsBoolean());
    }
}
