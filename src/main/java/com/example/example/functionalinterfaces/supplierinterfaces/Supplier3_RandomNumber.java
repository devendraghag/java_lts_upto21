package level02_intermediate.jdk8.functionalinterfaces.supplierinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Supplier;
import java.util.Random;

/*
 Supplier3: Supplies random numbers
*/
/**
 * Easy: Demonstrates Supplier3 Random Number in the Functional Interfaces / Supplier Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class Supplier3_RandomNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(100);
        System.out.println(randomSupplier.get());
    }
}
