package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

/**
 * JDK 21 BlockingQueue ladder (14/15): choosing an implementation via pattern matching switch.
 *
 * An interview decision guide, expressed as a switch expression over an enum need, instead of
 * an if/else chain. Each arm names the concrete BlockingQueue and the reason to pick it.
 */
/**
 * Easy: Demonstrates mapping a requirement enum to a recommended BlockingQueue implementation.
 * Medium: Track why each implementation fits its stated need (capacity, ordering, handoff, delay).
 * Tough: Be ready to justify the choice against the other six implementations in an interview.
 */
public class BlockingQueue14ImplementationSelectionSwitch {

    enum QueueNeed {
        BOUNDED_FIFO, UNBOUNDED_FIFO, PRIORITY_ORDER, TIME_GATED, DIRECT_HANDOFF, TRANSFER_AWARE
    }

    static String recommend(QueueNeed need) {
        return switch (need) {
            case BOUNDED_FIFO -> "ArrayBlockingQueue: fixed capacity, single array, natural backpressure";
            case UNBOUNDED_FIFO -> "LinkedBlockingQueue (no capacity arg): FIFO with effectively unlimited capacity";
            case PRIORITY_ORDER -> "PriorityBlockingQueue: unbounded, orders by Comparable/Comparator, not insertion order";
            case TIME_GATED -> "DelayQueue: elements implement Delayed, only leave once their delay has expired";
            case DIRECT_HANDOFF -> "SynchronousQueue: zero capacity, put() waits for a matching take()";
            case TRANSFER_AWARE -> "LinkedTransferQueue: unbounded like a normal queue, plus transfer()/tryTransfer()";
        };
    }

    public static void main(String[] args) {
        for (QueueNeed need : QueueNeed.values()) {
            System.out.println(need + " -> " + recommend(need));
        }
    }
}
