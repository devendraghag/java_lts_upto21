package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator25ThenComparingLong {
    record Message(String channel, long timestamp, String id) {}

    public static void main(String[] args) {
        List<Message> messages = List.of(
                new Message("alerts", 2_000_000_000L, "B"),
                new Message("alerts", 1_000_000_000L, "A"),
                new Message("chat", 1_000_000_000L, "C"));

        Comparator<Message> order = Comparator.comparing(Message::channel)
                .thenComparingLong(Message::timestamp)
                .thenComparing(Message::id);
        System.out.println(messages.stream().sorted(order).toList());
    }
}
