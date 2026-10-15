package level02_intermediate.jdk8.functionalinterfaces.supplierinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Supplier;
import java.util.Date;

/*
 Supplier2: Lazy object creation
 Object is created only when get() is called
*/
/**
 * Easy: Demonstrates Supplier2 Object Creation in the Functional Interfaces / Supplier Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class Supplier2_ObjectCreation {
    public static void main(String[] args) {
        Supplier<Date> dateSupplier = Date::new;
        System.out.println(dateSupplier.get());
    }
}
