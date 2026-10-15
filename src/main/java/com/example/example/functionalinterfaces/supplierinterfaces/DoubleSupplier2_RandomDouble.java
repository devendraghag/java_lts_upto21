package level02_intermediate.jdk8.functionalinterfaces.supplierinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.DoubleSupplier;
import java.util.Random;

/*
 DoubleSupplier2: Supplies random double value
*/
/**
 * Easy: Demonstrates Double Supplier2 Random Double in the Functional Interfaces / Supplier Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class DoubleSupplier2_RandomDouble {
    public static void main(String[] args) {
        Random random = new Random();
        DoubleSupplier randomSupplier = random::nextDouble;
        System.out.println(randomSupplier.getAsDouble());
    }
}
