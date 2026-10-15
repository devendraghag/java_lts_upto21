package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.DoubleFunction;

/**
 * Easy: Demonstrates Double Function3 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Price {
    double amount;
    Price(double amount) {
        this.amount = amount;
    }
}

class DoubleFunction3 {
    public static void main(String[] args) {
        // Factory pattern using constructor reference
        DoubleFunction<Price> priceFactory = Price::new;
        Price p = priceFactory.apply(99.99);
        System.out.println(p.amount);
    }
}