package level03_advanced.jdk17.sealedclasses;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.
/**
 * Demonstrates Type Choice Decision Demo through a small, executable example.
 *
 * <p>Read the type declarations first and then follow {@code main}: the declared reference
 * type determines which members are accessible at compile time, while an overridden instance
 * method is selected from the runtime object type. Any intentionally invalid statement remains
 * commented out so the valid behavior can still be compiled and run.</p>
 */

public class SealedClasses11TypeChoiceDecision {
    public static void main(String[] args) {
        System.out.println("ABSTRACT CLASS: shared state, constructors, protected helpers, partial implementation");
        System.out.println("INTERFACE: capability contract, unrelated implementors, multiple type inheritance");
        System.out.println("SEALED CLASS: closed, controlled class hierarchy with shared implementation");
        System.out.println("SEALED INTERFACE: closed set of implementations, useful for exhaustive pattern switch");
        System.out.println("RECORD: immutable data carrier; cannot extend a user class but can implement interfaces");
        System.out.println("ENUM: fixed named instances; can implement interfaces and declare abstract methods");
    }
}
