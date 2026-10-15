package com.example.collectionclasses.linkedtransferqueue;

import java.util.ArrayList;
import java.util.concurrent.LinkedTransferQueue;

public class LinkedTransferQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();
        queue.offer("message-1");
        queue.offer("message-2");
        queue.put("message-3"); // put/offer enqueue without waiting for a consumer.

        for (String message : queue) {
            System.out.println(message);
        }

        System.out.println("Waiting consumer exists: " + queue.hasWaitingConsumer());
        ArrayList<String> drained = new ArrayList<>();
        queue.drainTo(drained);
        System.out.println("drainTo conversion: " + drained);
        System.out.println("Queue empty: " + queue.isEmpty());
        queue.tryTransfer("message-4"); // Only transfers immediately if a consumer is waiting.
        System.out.println("Size after tryTransfer: " + queue.size());
        System.out.println("Peek: " + queue.peek());
        // transfer(element) blocks until a consumer receives that exact element.
    }
}
