package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.ObjDoubleConsumer;

/**
 * Easy: Demonstrates Obj Double Consumer Demo2 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ObjDoubleConsumerDemo2 {
    public static void main(String[] args) {

        ObjDoubleConsumer<String> evaluator =
                (employee, rating) -> {
                    if (rating >= 4.5)
                        System.out.println(employee + " is Outstanding");
                    else
                        System.out.println(employee + " is Good");
                };

        evaluator.accept("Bob", 4.7);
    }
}
