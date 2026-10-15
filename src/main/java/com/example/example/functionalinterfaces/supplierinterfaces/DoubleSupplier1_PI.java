package level02_intermediate.jdk8.functionalinterfaces.supplierinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.DoubleSupplier;

/*
 DoubleSupplier1: Supplies PI value
*/
/**
 * Easy: Demonstrates Double Supplier1 PI in the Functional Interfaces / Supplier Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class DoubleSupplier1_PI {
    public static void main(String[] args) {
        DoubleSupplier piSupplier = () -> Math.PI;
        System.out.println(piSupplier.getAsDouble());
    }
}
