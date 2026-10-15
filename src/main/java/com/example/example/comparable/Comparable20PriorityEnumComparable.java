package com.example.comparable;

import java.util.List;

public class Comparable20PriorityEnumComparable {
    enum Priority {
        NORMAL, HIGH, LOW, URGENT
    }

    public static void main(String[] args) {
        List<Priority> values = List.of(
                Priority.NORMAL, Priority.URGENT, Priority.LOW, Priority.HIGH);
        // Enum natural order follows declaration position, not a business priority field.
        System.out.println(values.stream().sorted().toList());
    }
}
