package com.example.varhandle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/** Demonstrates publishing data with setRelease and observing it with getAcquire. */
public class VarHandle03AcquireReleaseSemantics {
    private static final VarHandle READY;

    static {
        try {
            READY = MethodHandles.lookup().findVarHandle(PublishedData.class, "ready", boolean.class);
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            throw new ExceptionInInitializerError(exception);
        }
    }

    private static final class PublishedData {
        private int value;       // Written before the release operation.
        private boolean ready;   // Accessed through acquire/release VarHandle modes.
    }

    public static void main(String[] args) throws InterruptedException {
        PublishedData data = new PublishedData();

        Thread producer = new Thread(() -> {
            data.value = 42;
            READY.setRelease(data, true); // Publish value before announcing readiness.
        }, "producer");

        Thread consumer = new Thread(() -> {
            while (!(boolean) READY.getAcquire(data)) {
                Thread.onSpinWait(); // Hint that this thread is briefly waiting.
            }
            // Seeing ready=true with acquire also makes the earlier value write visible.
            System.out.println("Read published value: " + data.value);
        }, "consumer");

        consumer.start();
        producer.start();
        producer.join();
        consumer.join();
    }
}
