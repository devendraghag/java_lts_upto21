package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator18ComparingLong {
    record Event(String name, long epochMillis) {}

    public static void main(String[] args) {
        List<Event> events = List.of(
                new Event("later", 9_000_000_000L),
                new Event("first", 1_000_000_000L),
                new Event("middle", 5_000_000_000L));

        // comparingLong avoids boxing each long key into a Long object for comparison.
        Comparator<Event> byTime = Comparator.comparingLong(Event::epochMillis);
        System.out.println(events.stream().sorted(byTime).toList());
    }
}
