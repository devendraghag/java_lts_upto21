package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.ObjLongConsumer;

/**
 * Easy: Demonstrates Obj Long Consumer Demo3 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ObjLongConsumerDemo3 {
    public static void main(String[] args) {

        ObjLongConsumer<String> fileSizePrinter =
                (file, size) ->
                        System.out.println(file + " size(KB) = " + (size / 1024));

        fileSizePrinter.accept("data.txt", 8192L);
    }
}
