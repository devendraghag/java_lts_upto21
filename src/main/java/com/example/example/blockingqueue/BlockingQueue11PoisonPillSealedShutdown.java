package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * JDK 21 BlockingQueue ladder (11/15): poison-pill shutdown modeled with a sealed hierarchy.
 *
 * Instead of a magic sentinel value, the queue carries a sealed WorkItem type. The consumer
 * uses pattern matching for switch, which the compiler proves exhaustive over Job/Shutdown
 * without needing a default branch.
 */
/**
 * Easy: Demonstrates a sealed interface plus exhaustive switch replacing a raw sentinel poison pill.
 * Medium: Track how the consumer loop exits cleanly once the Shutdown record is taken.
 * Tough: Explain why sealed types make the switch exhaustiveness a compile-time guarantee, not a convention.
 */
public class BlockingQueue11PoisonPillSealedShutdown {

    sealed interface WorkItem permits Job, Shutdown {
    }

    record Job(String payload) implements WorkItem {
    }

    record Shutdown() implements WorkItem {
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<WorkItem> queue = new ArrayBlockingQueue<>(10);

        Thread consumer = Thread.ofVirtual().start(() -> {
            boolean running = true;
            while (running) {
                try {
                    WorkItem item = queue.take();
                    running = switch (item) {
                        case Job(String payload) -> {
                            System.out.println("Processing job: " + payload);
                            yield true;
                        }
                        case Shutdown ignored -> {
                            System.out.println("Shutdown received, consumer exiting");
                            yield false;
                        }
                    };
                } catch (InterruptedException interrupted) {
                    Thread.currentThread().interrupt();
                    running = false;
                }
            }
        });

        queue.put(new Job("send-invoice"));
        queue.put(new Job("archive-order"));
        queue.put(new Shutdown());

        consumer.join();
    }
}
