package com.example.interfacestaticmethods;

/** Demonstrates an interface static factory method returning an implementation. */
public class InterfaceStaticFactoryMethodDemo {
    @FunctionalInterface
    private interface Notifier {
        void send(String message);

        static Notifier console() {
            return message -> System.out.println("Notification: " + message);
        }
    }

    public static void main(String[] args) {
        Notifier notifier = Notifier.console();
        notifier.send("Service started");
    }
}
