package com.example.multithreading;

import java.util.concurrent.CountDownLatch;

/** Demonstrates monitor coordination with wait and notifyAll. */
public class WaitNotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch waiting = new CountDownLatch(1);
        ReadySignal signal = new ReadySignal(waiting);
        Thread worker = new Thread(signal::awaitReady, "waiting-worker");
        worker.start();

        waiting.await();
        signal.markReady();
        worker.join();
    }

    private static final class ReadySignal {
        private final CountDownLatch waiting;
        private boolean ready;

        private ReadySignal(CountDownLatch waiting) {
            this.waiting = waiting;
        }

        private synchronized void awaitReady() {
            while (!ready) {
                try {
                    System.out.println("Worker waiting");
                    waiting.countDown();
                    wait(); // Releases this object's monitor until notified.
                } catch (InterruptedException interrupted) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println("Worker proceeds");
        }

        private synchronized void markReady() {
            ready = true;
            notifyAll();
        }
    }
}
