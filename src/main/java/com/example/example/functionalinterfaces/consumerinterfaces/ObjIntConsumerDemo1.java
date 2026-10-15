package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.ObjIntConsumer;

/**
 * Easy: Demonstrates Obj Int Consumer Demo1 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ObjIntConsumerDemo1 {
    public static void main(String[] args) {

        // Object (String) + int (count)
        ObjIntConsumer<String> consumer =
                (name, count) ->
                        System.out.println(name + " count = " + count);

        consumer.accept("Java", 8);
    }
}
