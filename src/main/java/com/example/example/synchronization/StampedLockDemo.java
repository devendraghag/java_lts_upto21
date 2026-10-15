package com.example.synchronization;

import java.util.concurrent.locks.StampedLock;

/** Demonstrates optimistic reads and validation with StampedLock. */
public class StampedLockDemo {
    private static final class Point {
        private final StampedLock lock = new StampedLock();
        private double x;
        private double y;

        private void move(double deltaX, double deltaY) {
            long stamp = lock.writeLock();
            try {
                x += deltaX;
                y += deltaY;
            } finally {
                lock.unlockWrite(stamp);
            }
        }

        private double distanceFromOrigin() {
            long stamp = lock.tryOptimisticRead();
            double currentX = x;
            double currentY = y;
            if (!lock.validate(stamp)) {
                stamp = lock.readLock();
                try {
                    currentX = x;
                    currentY = y;
                } finally {
                    lock.unlockRead(stamp);
                }
            }
            return Math.hypot(currentX, currentY);
        }
    }

    public static void main(String[] args) {
        Point point = new Point();
        point.move(3, 4);
        System.out.println("Distance: " + point.distanceFromOrigin());
    }
}
