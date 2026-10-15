package com.example.synchronization;

/** Demonstrates wait/notifyAll with a condition checked in a loop. */
public class WaitNotifyProducerConsumerDemo {
    private static final class OneSlotBuffer {
        private Integer value;

        public synchronized void put(int newValue) throws InterruptedException {
            while (value != null) {
                wait();
            }
            value = newValue;
            System.out.println("Produced " + newValue);
            notifyAll();
        }

        public synchronized int take() throws InterruptedException {
            while (value == null) {
                wait();
            }
            int result = value;
            value = null;
            System.out.println("Consumed " + result);
            notifyAll();
            return result;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OneSlotBuffer buffer = new OneSlotBuffer();
        Thread producer = new Thread(() -> {
            try {
                buffer.put(21);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                buffer.take();
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        });

        consumer.start();
        producer.start();
        producer.join();
        consumer.join();
    }
}
