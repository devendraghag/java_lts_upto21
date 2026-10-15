package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * JDK 21 BlockingQueue ladder (12/15): record patterns routing queued events.
 *
 * Combines two JDK 21 features with BlockingQueue: a sealed Event hierarchy pulled off
 * the queue is destructured with nested record patterns inside a switch expression,
 * routing each event to the right handling branch in one exhaustive statement.
 */
/**
 * Easy: Demonstrates destructuring queued records directly in a switch's case labels.
 * Medium: Track how nested record patterns pull fields out of Customer without manual getters.
 * Tough: Explain how dominance rules would matter if a broader Event pattern were added before the specific ones.
 */
public class BlockingQueue12RecordPatternTaskRouting {

    record Customer(String id, String tier) {
    }

    sealed interface Event permits OrderEvent, PaymentEvent {
    }

    record OrderEvent(Customer customer, double amount) implements Event {
    }

    record PaymentEvent(Customer customer, boolean successful) implements Event {
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Event> queue = new LinkedBlockingQueue<>();

        queue.put(new OrderEvent(new Customer("C-1", "GOLD"), 250.0));
        queue.put(new PaymentEvent(new Customer("C-2", "STANDARD"), false));
        queue.put(new OrderEvent(new Customer("C-3", "GOLD"), 40.0));

        for (int i = 0; i < 3; i++) {
            Event event = queue.take();
            String routed = switch (event) {
                case OrderEvent(Customer(var id, var tier), var amount) when tier.equals("GOLD") ->
                        "Priority-route order " + amount + " for GOLD customer " + id;
                case OrderEvent(Customer(var id, var tier), var amount) ->
                        "Standard-route order " + amount + " for " + tier + " customer " + id;
                case PaymentEvent(Customer(var id, var tier), boolean successful) when !successful ->
                        "Alert: failed payment for customer " + id + " (" + tier + ")";
                case PaymentEvent(Customer(var id, var tier), var successful) ->
                        "Payment " + successful + " recorded for customer " + id + " (" + tier + ")";
            };
            System.out.println(routed);
        }
    }
}
