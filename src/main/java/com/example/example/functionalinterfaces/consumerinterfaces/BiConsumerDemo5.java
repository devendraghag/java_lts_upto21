package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiConsumer;

/*
 * USE CASE:
 * - Behavior belongs to object
 */
/**
 * Easy: Demonstrates Bi Consumer Demo5 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Calculatorr {
    void divide(int a, int b) {
        System.out.println(a / b);
    }
}

public class BiConsumerDemo5 {
    public static void main(String[] args) {

        Calculatorr calc = new Calculatorr();

        // accept(a,b) → calc.divide(a,b)
        BiConsumer<Integer, Integer> bc = calc::divide;
        bc.accept(20, 4);
    }
}
