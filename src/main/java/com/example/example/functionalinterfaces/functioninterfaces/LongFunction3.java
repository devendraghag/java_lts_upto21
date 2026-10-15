package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongFunction;

/**
 * Easy: Demonstrates Long Function3 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Orderr {
    long orderId;

    Orderr(long orderId) {
        this.orderId = orderId;
    }
}

public class LongFunction3 {
    public static void main(String[] args) {

        // Creates Order object using long input
        LongFunction<Orderr> orderFactory = Orderr::new;

        Orderr o = orderFactory.apply(12345L);
        System.out.println(o.orderId);
    }
}
