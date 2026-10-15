package level02_intermediate.jdk8.functionalinterfaces.supplierinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongSupplier;

/*
 LongSupplier1: Supplies current system time
*/
/**
 * Easy: Demonstrates Long Supplier1 Current Time in the Functional Interfaces / Supplier Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class LongSupplier1_CurrentTime {
    public static void main(String[] args) {
        LongSupplier timeSupplier = System::currentTimeMillis;
        System.out.println(timeSupplier.getAsLong());
    }
}
