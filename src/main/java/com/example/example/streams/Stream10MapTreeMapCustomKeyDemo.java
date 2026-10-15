package com.example.streams;

import java.util.Map;
import java.util.TreeMap;

/** Streams entries from a TreeMap whose keys are instances of a custom class. */
public class Stream10MapTreeMapCustomKeyDemo {
    public static void main(String[] args) {
        // TreeMap uses the supplied comparator to order Department keys.
        Map<Department, Integer> openPositions = new TreeMap<>(
                (first, second) -> first.getName().compareTo(second.getName()));
        openPositions.put(new Department("Sales", "SLS"), 2);
        openPositions.put(new Department("Engineering", "ENG"), 5);
        openPositions.put(new Department("Support", "SUP"), 0);

        // The map itself is ordered by Department name. This stream keeps
        // departments that currently have at least one open position.
        openPositions.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(entry -> entry.getKey().getName()
                        + " (" + entry.getKey().getCode() + "): "
                        + entry.getValue() + " open positions")
                .forEach(System.out::println);
    }

    /** Custom map key; TreeMap compares these by name using its comparator. */
    private static class Department {
        private final String name;
        private final String code;

        private Department(String name, String code) {
            this.name = name;
            this.code = code;
        }

        private String getName() {
            return name;
        }

        private String getCode() {
            return code;
        }
    }
}