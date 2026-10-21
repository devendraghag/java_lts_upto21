package com.example.example.interviewprograms.p54_stream_keyset_filter_ids;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/** Additional example: Filter Map Keys with a Stream. Standard Java Map only. */
public class StreamKeySetFilterIds {
    public static void main(String[] args) {
        Map<Integer, String> employeeNameById = new LinkedHashMap<>();
        employeeNameById.put(1001, "Asha");
        employeeNameById.put(1002, "Ravi");
        employeeNameById.put(1003, "Mina");
        employeeNameById.put(1004, "Dev");

        String evenIds = employeeNameById.keySet().stream()
                .filter(id -> id % 2 == 0)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Even employee IDs: " + evenIds);
    }
}
