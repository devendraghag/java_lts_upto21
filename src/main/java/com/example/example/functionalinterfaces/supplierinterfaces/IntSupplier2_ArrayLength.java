package level02_intermediate.jdk8.functionalinterfaces.supplierinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntSupplier;

/*
 IntSupplier2: Supplies array length
*/
/**
 * Easy: Demonstrates Int Supplier2 Array Length in the Functional Interfaces / Supplier Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class IntSupplier2_ArrayLength {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        IntSupplier lengthSupplier = () -> arr.length;
        System.out.println(lengthSupplier.getAsInt());
    }
}
