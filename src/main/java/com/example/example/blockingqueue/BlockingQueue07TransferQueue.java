package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/** Level 7: transfer() waits until a consumer receives the element. */
public class BlockingQueue07TransferQueue {
    public static void main(String[] args) throws Exception {
        TransferQueue<String> queue = new LinkedTransferQueue<>();
        ExecutorService workers = Executors.newSingleThreadExecutor();

        try {
            Future<String> receiver = workers.submit(queue::take);
            queue.transfer("transferred item");
            System.out.println(receiver.get());
        } finally {
            workers.shutdownNow();
        }
    }
}