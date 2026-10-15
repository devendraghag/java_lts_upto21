package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * JDK 21 BlockingQueue ladder (04/15): fairness of waiting virtual threads.
 *
 * ArrayBlockingQueue accepts a fairness flag. When true, waiting producers/consumers
 * are served in FIFO wait order (a fair ReentrantLock); when false (the default),
 * ordering among waiters is not guaranteed, trading fairness for throughput.
 */
/**
 * Easy: Demonstrates constructing a fair ArrayBlockingQueue and observing service order.
 * Medium: Compare fair ordering against the default unfair mode's lack of ordering guarantee.
 * Tough: Explain the throughput cost of fairness and when it is worth paying.
 */
public class BlockingQueue04FairnessOrdering {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> fairQueue = new ArrayBlockingQueue<>(1, true);
        fairQueue.put(0);

        List<Integer> serviceOrder = new CopyOnWriteArrayList<>();
        int waiterCount = 5;
        CountDownLatch allDone = new CountDownLatch(waiterCount);
        List<Thread> waiters = new ArrayList<>();

        for (int id = 1; id <= waiterCount; id++) {
            int waiterId = id;
            Thread waiter = Thread.ofVirtual().unstarted(() -> {
                try {
                    fairQueue.put(waiterId);
                } catch (InterruptedException interrupted) {
                    Thread.currentThread().interrupt();
                } finally {
                    allDone.countDown();
                }
            });
            waiters.add(waiter);
        }

        for (Thread waiter : waiters) {
            waiter.start();
            Thread.sleep(20);
        }

        for (int i = 0; i < waiterCount; i++) {
            serviceOrder.add(fairQueue.take());
            Thread.sleep(20);
        }

        allDone.await();
        System.out.println("Fair queue served waiting producers in order: " + serviceOrder);
        System.out.println("Fair mode favors predictable ordering over raw throughput.");
    }
}
