package com.example.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/** Coordinates producer and consumer threads using a bounded BlockingQueue. */
public class ProducerConsumerBlockingQueueDemo {
    private static final String STOP = "<stop>";

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(2);
        Thread consumer = new Thread(() -> consume(queue), "consumer");
        Thread producer = new Thread(() -> produce(queue), "producer");

        consumer.start();
        producer.start();
        producer.join();
        consumer.join();
    }

    private static void produce(BlockingQueue<String> queue) {
        try {
            for (String item : new String[] {"task-1", "task-2", "task-3"}) {
                queue.put(item); // Blocks when the bounded queue is full.
                System.out.println("Produced " + item);
            }
            queue.put(STOP);
        } catch (InterruptedException interrupted) {
            Thread.currentThread().interrupt();
        }
    }

    private static void consume(BlockingQueue<String> queue) {
        try {
            while (true) {
                String item = queue.take(); // Blocks while the queue is empty.
                if (STOP.equals(item)) return;
                System.out.println("Consumed " + item);
            }
        } catch (InterruptedException interrupted) {
            Thread.currentThread().interrupt();
        }
    }
}
