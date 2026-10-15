package com.example.terminaloperations;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** Harder: groupingBy performs a terminal collection with a downstream counting collector. */
public class TerminalOperationPractice14GroupingAndCounting {
    record Ticket(String category, String title) {
    }

    public static void main(String[] args) {
        List<Ticket> tickets = List.of(
                new Ticket("BUG", "Login fails"),
                new Ticket("TASK", "Update guide"),
                new Ticket("BUG", "Export fails"),
                new Ticket("QUESTION", "How to configure?"));

        Map<String, Long> countByCategory = tickets.stream().collect(
                Collectors.groupingBy(Ticket::category, Collectors.counting()));

        System.out.println(countByCategory);
    }
}
