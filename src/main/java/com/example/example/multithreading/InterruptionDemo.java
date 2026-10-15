package com.example.multithreading;

/** Demonstrates cooperative thread cancellation through interruption. */
public class InterruptionDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Worker is active");
                    Thread.sleep(50);
                }
            } catch (InterruptedException interrupted) {
                // Sleeping clears the interrupt flag when it throws; restore it before exit.
                Thread.currentThread().interrupt();
            }
            System.out.println("Worker stopped after interruption");
        });

        worker.start();
        Thread.sleep(130);
        worker.interrupt();
        worker.join();
    }
}
