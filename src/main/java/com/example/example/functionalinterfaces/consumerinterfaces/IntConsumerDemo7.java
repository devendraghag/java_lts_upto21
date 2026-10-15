package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntConsumer;

/**
 * Easy: Demonstrates Int Consumer Demo7 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class IntConsumerDemo7 {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30};

        // IntConsumer used for index-based access
        IntConsumer indexConsumer = i ->
                System.out.println("Index " + i + " -> " + arr[i]);

        for (int i = 0; i < arr.length; i++) {
            indexConsumer.accept(i);
        }
    }
}
