package com.example.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;

/** Demonstrates one-time and recurring task scheduling. */
public class ScheduledExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        CountDownLatch ticks = new CountDownLatch(3);
        try {
            scheduler.schedule(
                    () -> System.out.println("One-time delayed task"),
                    50,
                    TimeUnit.MILLISECONDS);
            scheduler.scheduleAtFixedRate(() -> {
                System.out.println("Scheduled tick");
                ticks.countDown();
            }, 0, 50, TimeUnit.MILLISECONDS);

            ticks.await();
        } finally {
            scheduler.shutdownNow();
        }
    }
}
