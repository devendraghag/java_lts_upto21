package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * JDK 21 BlockingQueue ladder (08/15): LinkedTransferQueue and transfer() semantics.
 *
 * TransferQueue adds transfer(), which behaves like SynchronousQueue.put() only when a
 * consumer is waiting, but otherwise buffers the element like an unbounded queue. This
 * differs from plain put(), which never waits for consumption.
 */
/**
 * Easy: Demonstrates put() returning immediately versus transfer() waiting for a consumer.
 * Medium: Track how tryTransfer() with a timeout reports whether a handoff occurred.
 * Tough: Explain when a TransferQueue is preferable to both LinkedBlockingQueue and SynchronousQueue.
 */
public class BlockingQueue08TransferVsPut {

    public static void main(String[] args) throws InterruptedException {
        TransferQueue<String> queue = new LinkedTransferQueue<>();

        queue.put("buffered-item");
        System.out.println("put() returned immediately; queue size: " + queue.size());
        System.out.println("Draining buffered item: " + queue.take());

        boolean transferredWithoutWaiter = queue.tryTransfer("no-consumer-yet");
        System.out.println("tryTransfer() with no waiting consumer succeeded: " + transferredWithoutWaiter);

        Thread consumer = Thread.ofVirtual().start(() -> {
            try {
                Thread.sleep(150);
                System.out.println("Consumer: taking transferred value -> " + queue.take());
            } catch (InterruptedException interrupted) {
                Thread.currentThread().interrupt();
            }
        });

        boolean transferred = queue.tryTransfer("handoff-value", 1, TimeUnit.SECONDS);
        System.out.println("tryTransfer() waited for the late consumer and succeeded: " + transferred);

        consumer.join();
    }
}
