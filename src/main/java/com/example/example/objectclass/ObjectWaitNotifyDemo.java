package com.example.objectclass;

/** Uses Object.wait() and notifyAll() with a guarded condition. */
public class ObjectWaitNotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        Signal signal = new Signal();
        Thread waiter = new Thread(() -> {
            try {
                signal.awaitOpen();
                System.out.println("Waiter observed the open signal");
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        });

        waiter.start();
        signal.open();
        waiter.join();
    }

    private static class Signal {
        private boolean open;

        synchronized void awaitOpen() throws InterruptedException {
            while (!open) {
                wait(); // Releases this object's monitor and reacquires it before returning.
            }
        }

        synchronized void open() {
            open = true;
            notifyAll(); // Must own this object's monitor; wakes all waiting threads.
        }
    }
}
