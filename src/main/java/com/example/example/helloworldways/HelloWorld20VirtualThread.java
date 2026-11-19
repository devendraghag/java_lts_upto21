package com.example.example.helloworldways;

/** Java 21: prints the greeting from a virtual thread and waits for it to finish. */
public class HelloWorld20VirtualThread {
    public static void main(String[] args) throws InterruptedException {
        Thread greetingThread = Thread.startVirtualThread(() -> System.out.println("Hello, World!"));
        greetingThread.join();
    }
}
