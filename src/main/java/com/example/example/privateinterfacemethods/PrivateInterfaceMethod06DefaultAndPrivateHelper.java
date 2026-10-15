package org.example.lts_features.level03_advanced.jdk09.privateinterfacemethods;

// JDK history: Interfaces were introduced in JDK 1.0. Interface default methods were introduced in JDK 8.


// Interface with default and private methods
/**
 * Easy: Demonstrates Interface Demo in the Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
interface Greeter {
    void greet(); // abstract method

    // default method using a private helper method
    default void sayFarewell() {
        System.out.println(getFarewellMessage());
    }

    // private helper method (Java 9+ feature)
    private String getFarewellMessage() {
        return "Goodbye from Greeter interface!";
    }
}

// Implementing class
class FriendlyPerson implements Greeter {
    @Override
    public void greet() {
        System.out.println("Hello! Nice to meet you.");
    }
}

// Main class
public class PrivateInterfaceMethod06DefaultAndPrivateHelper {
    public static void main(String[] args) {
        FriendlyPerson person = new FriendlyPerson();
        person.greet();        // implemented method
        person.sayFarewell();  // default method (uses private method)
    }
}
