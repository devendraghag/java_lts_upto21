package level02_intermediate.jdk8.functionalinterfaces.supplierinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongSupplier;

/*
 LongSupplier2: ID generator
*/
/**
 * Easy: Demonstrates Long Supplier2 Id Generator in the Functional Interfaces / Supplier Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class LongSupplier2_IdGenerator {
    static long id = 1000;
    public static void main(String[] args) {
        LongSupplier idSupplier = () -> ++id;
        System.out.println(idSupplier.getAsLong());
    }
}
