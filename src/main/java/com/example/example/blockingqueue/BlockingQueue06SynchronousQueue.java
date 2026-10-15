package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;

/** Level 6: SynchronousQueue stores no elements; put and take rendezvous directly. */
public class BlockingQueue06SynchronousQueue {
    public static void main(String[] args) throws Exception {
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        ExecutorService workers = Executors.newFixedThreadPool(2);

        try {
            Future<String> receiver = workers.submit(queue::take);
            queue.put("handed directly to the receiver");
            System.out.println(receiver.get());
        } finally {
            workers.shutdownNow();
        }
    }
}