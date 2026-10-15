package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.ToDoubleFunction;

/**
 * Easy: Demonstrates To Double Function2 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Product1 {
    double price;
    Product1(double price) { this.price = price; }
}

class ToDoubleFunction2 {
    public static void main(String[] args) {
        // Extract double field
        ToDoubleFunction<Product1> getPrice =
                p -> p.price;
        System.out.println(getPrice.applyAsDouble(new Product1(99.99)));
    }
}