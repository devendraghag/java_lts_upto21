package com.example.synchronization;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/** Demonstrates shared read locks and exclusive write locks. */
public class ReadWriteLockDemo {
    private static final class Settings {
        private final ReadWriteLock lock = new ReentrantReadWriteLock();
        private String value = "initial";

        private String read() {
            lock.readLock().lock();
            try {
                return value;
            } finally {
                lock.readLock().unlock();
            }
        }

        private void write(String newValue) {
            lock.writeLock().lock();
            try {
                value = newValue;
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

    public static void main(String[] args) {
        Settings settings = new Settings();
        System.out.println(settings.read());
        settings.write("updated");
        System.out.println(settings.read());
    }
}
