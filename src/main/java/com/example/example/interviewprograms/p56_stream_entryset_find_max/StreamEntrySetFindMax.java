package com.example.example.interviewprograms.p56_stream_entryset_find_max;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/** Additional example: Find the Largest Map Entry. Standard Java Map only. */
public class StreamEntrySetFindMax {
    public static void main(String[] args) {
        Map<String, Integer> monthlySales = new LinkedHashMap<>();
        monthlySales.put("January", 420);
        monthlySales.put("February", 510);
        monthlySales.put("March", 475);

        Optional<Map.Entry<String, Integer>> bestMonth = monthlySales.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        bestMonth.ifPresent(entry -> System.out.println(
                entry.getKey() + " had the highest sales: " + entry.getValue()));
    }
}
