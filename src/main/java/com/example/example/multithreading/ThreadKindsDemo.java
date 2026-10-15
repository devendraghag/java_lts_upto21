package com.example.multithreading;

/** Compares platform user threads, daemon threads, and virtual threads. */
public class ThreadKindsDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread userPlatform = new Thread(() -> work("platform user thread"), "platform-user");
        Thread daemonPlatform = new Thread(() -> work("platform daemon thread"), "platform-daemon");
        daemonPlatform.setDaemon(true); // Must be set before start().

        Thread virtual = Thread.ofVirtual()
                .name("virtual-worker")
                .start(() -> work("virtual thread"));

        System.out.println("Platform user thread is daemon: " + userPlatform.isDaemon());
        System.out.println("Platform daemon thread is daemon: " + daemonPlatform.isDaemon());
        System.out.println("Virtual thread? " + virtual.isVirtual());

        userPlatform.start();
        daemonPlatform.start();
        userPlatform.join();
        daemonPlatform.join();
        virtual.join();
    }

    private static void work(String kind) {
        System.out.println("Running " + kind + " as " + Thread.currentThread());
    }
}
