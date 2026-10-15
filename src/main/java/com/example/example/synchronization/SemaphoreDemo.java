package com.example.synchronization;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/** Demonstrates a semaphore limiting concurrent access to a resource. */
public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {
        Semaphore permits = new Semaphore(2);
        AtomicInteger activeWorkers = new AtomicInteger();
        Runnable task = () -> {
            boolean acquired = false;
            try {
                permits.acquire();
                acquired = true;
                int active = activeWorkers.incrementAndGet();
                System.out.println("Worker entered; active=" + active);
                Thread.sleep(50);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            } finally {
                if (acquired) {
                    activeWorkers.decrementAndGet();
                    permits.release();
                }
            }
        };

        Thread[] workers = new Thread[4];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Thread(task, "worker-" + (i + 1));
            workers[i].start();
        }
        for (Thread worker : workers) {
            worker.join();
        }
    }
}
