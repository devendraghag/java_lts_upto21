package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/** Level 3: use a bounded BlockingQueue to connect a producer and consumer. */
public class BlockingQueue03ProducerConsumer {
    private static final String STOP = "STOP";

    public static void main(String[] args) throws Exception {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);
        ExecutorService workers = Executors.newFixedThreadPool(2);

        try {
            Future<?> consumer = workers.submit(() -> {
                while (true) {
                    String item = queue.take();
                    if (STOP.equals(item)) {
                        break;
                    }
                    System.out.println("Consumed: " + item);
                }
                return null;
            });

            Future<?> producer = workers.submit(() -> {
                for (int i = 1; i <= 4; i++) {
                    queue.put("item-" + i);
                }
                queue.put(STOP);
                return null;
            });

            producer.get();
            consumer.get();
        } finally {
            workers.shutdownNow();
        }
    }
}