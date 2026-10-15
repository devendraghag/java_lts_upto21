package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.ToLongFunction;

/**
 * Easy: Demonstrates To Long Function2 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Order {
    long id;
    Order(long id) { this.id = id; }
}

class ToLongFunction2 {
    public static void main(String[] args) {
        // Extract long field
        ToLongFunction<Order> getId = o -> o.id;
        System.out.println(getId.applyAsLong(new Order(9999L)));
    }
}