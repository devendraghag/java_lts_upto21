package com.example.statickeyword;

/** Demonstrates class-level fields shared by all instances. */
public class StaticFieldsDemo {
    public static void main(String[] args) {
        VisitCounter first = new VisitCounter();
        VisitCounter second = new VisitCounter();
        first.recordVisit();
        second.recordVisit();
        first.recordVisit();

        System.out.println("Shared visits: " + VisitCounter.visits);
        System.out.println("Application: " + VisitCounter.APPLICATION_NAME);
    }

    private static final class VisitCounter {
        private static int visits;
        private static final String APPLICATION_NAME = "Static Demo";

        private void recordVisit() {
            visits++;
        }
    }
}
