package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.List;
import java.util.function.ObjIntConsumer;

/**
 * Easy: Demonstrates Obj Int Consumer Demo3 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ObjIntConsumerDemo3 {
    public static void main(String[] args) {

        List<String> list = java.util.Arrays.asList("A", "B", "C");

        ObjIntConsumer<List<String>> printer =
                (l, index) ->
                        System.out.println("Index " + index + " -> " + l.get(index));

        printer.accept(list, 1);
    }
}
