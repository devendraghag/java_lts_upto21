package com.example.dynamicmethoddispatch;

import java.util.List;

/**
 * Demonstrates dynamic method dispatch (runtime polymorphism) in Java through JDK 21.
 * Includes superclass, abstract-class, interface, and sealed-type examples.
 * No preview or incubator APIs are used.
 *
 * Compile and run from the source root:
 *   javac -d out com/example/dynamicmethoddispatch/DynamicMethodDispatchExamples.java
 *   java -cp out com.example.dynamicmethoddispatch.DynamicMethodDispatchExamples
 */
public class DynamicMethodDispatchExamples {
    public static void main(String[] args) {
        superclassReferenceDispatch();
        abstractClassDispatch();
        interfaceReferenceDispatch();
        compileTimeAndRuntimeSelection();
        sealedHierarchyDispatch();
    }

    private static void superclassReferenceDispatch() {
        System.out.println("== Dispatch through a superclass reference ==");

        List<Animal> animals = List.of(new Dog(), new Cat());
        for (Animal animal : animals) {
            animal.speak(); // runtime class selects the overriding implementation
        }
    }

    private static void abstractClassDispatch() {
        System.out.println("\n== Dispatch through an abstract-class reference ==");

        List<Worker> workers = List.of(new Developer("Mina"), new Designer("Ravi"));
        for (Worker worker : workers) {
            worker.introduce();
            worker.performTask();
        }
    }

    private static void interfaceReferenceDispatch() {
        System.out.println("\n== Dispatch through an interface reference ==");

        List<PaymentMethod> methods = List.of(new CardPayment(), new CashPayment());
        for (PaymentMethod method : methods) {
            method.pay(25.50);
        }
    }

    private static void compileTimeAndRuntimeSelection() {
        System.out.println("\n== Runtime overriding versus compile-time selection ==");

        BasePrinter printer = new ColorPrinter();
        printer.print(); // overridden instance method is selected at runtime

        // The overload is chosen at compile time from the declared type BasePrinter.
        // Then the selected print(Object) signature dispatches to its override.
        printer.print("document");

        // Static methods are hidden, not overridden; the reference/class type selects them.
        printer.mode();
        ColorPrinter.mode();

        // Fields are hidden, not dynamically dispatched.
        System.out.println("field through BasePrinter reference: " + printer.label);
        System.out.println("field through ColorPrinter reference: " + ((ColorPrinter) printer).label);
    }

    private static void sealedHierarchyDispatch() {
        System.out.println("\n== Dispatch in a sealed hierarchy (JDK 17+) ==");

        List<Notification> notifications = List.of(
                new EmailNotification("Build finished"),
                new SmsNotification("Code 1234")
        );
        notifications.forEach(Notification::send);
    }

    private abstract static class Animal {
        abstract void speak();
    }

    private static final class Dog extends Animal {
        @Override
        void speak() {
            System.out.println("Dog says woof");
        }
    }

    private static final class Cat extends Animal {
        @Override
        void speak() {
            System.out.println("Cat says meow");
        }
    }

    private abstract static class Worker {
        private final String name;

        private Worker(String name) {
            this.name = name;
        }

        void introduce() {
            System.out.println("Worker: " + name);
        }

        abstract void performTask();
    }

    private static final class Developer extends Worker {
        private Developer(String name) {
            super(name);
        }

        @Override
        void performTask() {
            System.out.println("Developer writes code");
        }
    }

    private static final class Designer extends Worker {
        private Designer(String name) {
            super(name);
        }

        @Override
        void performTask() {
            System.out.println("Designer creates a layout");
        }
    }

    private interface PaymentMethod {
        void pay(double amount);
    }

    private static final class CardPayment implements PaymentMethod {
        @Override
        public void pay(double amount) {
            System.out.println("Paid by card: " + amount);
        }
    }

    private static final class CashPayment implements PaymentMethod {
        @Override
        public void pay(double amount) {
            System.out.println("Paid by cash: " + amount);
        }
    }

    private static class BasePrinter {
        String label = "base printer";

        void print() {
            System.out.println("BasePrinter.print()");
        }

        void print(Object value) {
            System.out.println("BasePrinter.print(Object): " + value);
        }

        static void mode() {
            System.out.println("BasePrinter.mode (static)");
        }
    }

    private static final class ColorPrinter extends BasePrinter {
        String label = "color printer";

        @Override
        void print() {
            System.out.println("ColorPrinter.print() (override)");
        }

        @Override
        void print(Object value) {
            System.out.println("ColorPrinter.print(Object) (override): " + value);
        }

        // Overload exists only on ColorPrinter; a BasePrinter reference cannot select it.
        void print(String value) {
            System.out.println("ColorPrinter.print(String) (overload): " + value);
        }

        static void mode() {
            System.out.println("ColorPrinter.mode (static hiding)");
        }
    }

    private sealed interface Notification permits EmailNotification, SmsNotification {
        void send();
    }

    private static final class EmailNotification implements Notification {
        private final String message;

        private EmailNotification(String message) {
            this.message = message;
        }

        @Override
        public void send() {
            System.out.println("Email: " + message);
        }
    }

    private static final class SmsNotification implements Notification {
        private final String message;

        private SmsNotification(String message) {
            this.message = message;
        }

        @Override
        public void send() {
            System.out.println("SMS: " + message);
        }
    }
}
