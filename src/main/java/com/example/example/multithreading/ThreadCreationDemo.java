package com.example.multithreading;

/** Demonstrates extending Thread and supplying Runnable tasks. */
public class ThreadCreationDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread subclass = new GreetingThread();
        Thread runnable = new Thread(new GreetingTask("Runnable object"));
        Thread lambda = new Thread(() -> printGreeting("Runnable lambda"));

        subclass.start();
        runnable.start();
        lambda.start();

        subclass.join();
        runnable.join();
        lambda.join();
        System.out.println("All worker threads completed.");
    }

    private static void printGreeting(String kind) {
        System.out.println(kind + " on " + Thread.currentThread().getName());
    }

    private static final class GreetingThread extends Thread {
        private GreetingThread() {
            super("thread-subclass");
        }

        @Override
        public void run() {
            printGreeting("Thread subclass");
        }
    }

    private static final class GreetingTask implements Runnable {
        private final String kind;

        private GreetingTask(String kind) {
            this.kind = kind;
        }

        @Override
        public void run() {
            printGreeting(kind);
        }
    }
}
