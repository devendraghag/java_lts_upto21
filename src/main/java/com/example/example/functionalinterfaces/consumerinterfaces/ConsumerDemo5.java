package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Consumer;

/*
 * USE CASE:
 * - Logic belongs to an object
 */
/**
 * Easy: Demonstrates Consumer Demo5 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */

//instance method reference
class Printerr {
    void print(Integer t) {
        System.out.println("Value: " + t);
    }
}

public class ConsumerDemo5 {
    public static void main(String[] args) {

        Printerr p = new Printerr();

        // accept(t) → p.print(t)
        Consumer<Integer> c = p::print;

        c.accept(40);
    }
}
