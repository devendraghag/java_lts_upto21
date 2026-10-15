package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.ObjDoubleConsumer;

/**
 * Easy: Demonstrates Obj Double Consumer Demo3 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ObjDoubleConsumerDemo3 {
    public static void main(String[] args) {

        ObjDoubleConsumer<String> taxCalculator =
                (product, price) -> {
                    double tax = price * 0.18;
                    System.out.println(product + " final price = " + (price + tax));
                };

        taxCalculator.accept("Laptop", 50000.0);
    }
}
