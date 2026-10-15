package level02_intermediate.jdk8.functionalinterfaces.supplierinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntSupplier;

/*
 IntSupplier1: Counter supplier
*/
/**
 * Easy: Demonstrates Int Supplier1 Counter in the Functional Interfaces / Supplier Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class IntSupplier1_Counter {
    static int count = 0;
    public static void main(String[] args) {
        IntSupplier counter = () -> ++count;
        System.out.println(counter.getAsInt());
        System.out.println(counter.getAsInt());
    }
}
