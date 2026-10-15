package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * JDK 21 BlockingQueue ladder (15/15): capstone pipeline tying the ladder together.
 *
 * A virtual-thread-per-task executor feeds a bounded intake queue. A dedicated consumer
 * virtual thread drains it with an exhaustive switch over a sealed WorkItem, and a
 * Shutdown record acts as the poison pill that ends the pipeline once all jobs are queued.
 */
/**
 * Easy: Demonstrates a producer executor, a bounded intake queue, and a consumer working together.
 * Medium: Track how the bounded queue applies backpressure to the submitting executor under load.
 * Tough: Explain how this composes bounded queues, sealed types, pattern matching, and virtual threads
 * into one graceful-shutdown pipeline.
 */
public class BlockingQueue15StructuredVirtualThreadPerTaskPipeline {

    sealed interface WorkItem permits Job, Shutdown {
    }

    record Job(int id, String description) implements WorkItem {
    }

    record Shutdown() implements WorkItem {
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<WorkItem> intake = new ArrayBlockingQueue<>(5);

        Thread consumer = Thread.ofVirtual().start(() -> {
            int processed = 0;
            boolean running = true;
            while (running) {
                try {
                    WorkItem item = intake.take();
                    running = switch (item) {
                        case Job(int id, String description) -> {
                            System.out.println("Consumer handled job " + id + ": " + description);
                            yield true;
                        }
                        case Shutdown ignored -> false;
                    };
                } catch (InterruptedException interrupted) {
                    Thread.currentThread().interrupt();
                    running = false;
                }
            }
        });

        try (ExecutorService producers = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 1; i <= 12; i++) {
                int jobId = i;
                producers.submit(() -> {
                    intake.put(new Job(jobId, "task-" + jobId));
                    return null;
                });
            }
        }

        intake.put(new Shutdown());
        consumer.join();
        System.out.println("Pipeline drained and shut down cleanly.");
    }
}
