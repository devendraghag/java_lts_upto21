package level02_intermediate.jdk8.functionalinterfaces.supplierinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Supplier;

/*
 Supplier5: Factory-style object creation
*/
/**
 * Easy: Demonstrates Supplier5 Factory Method in the Functional Interfaces / Supplier Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class User {
    String name = "Guest";
}

public class Supplier5_FactoryMethod {
    public static void main(String[] args) {
        Supplier<User> userFactory = User::new;
        User user = userFactory.get();
        System.out.println(user.name);
    }
}
