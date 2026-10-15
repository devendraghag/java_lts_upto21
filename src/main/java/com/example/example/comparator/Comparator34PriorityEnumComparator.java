package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator34PriorityEnumComparator {
    enum Priority {
        NORMAL(2), HIGH(3), LOW(1), URGENT(4);

        private final int rank;

        Priority(int rank) {
            this.rank = rank;
        }

        int rank() {
            return rank;
        }
    }

    public static void main(String[] args) {
        List<Priority> values = List.of(
                Priority.NORMAL, Priority.URGENT, Priority.LOW, Priority.HIGH);

        // The comparator expresses business rank independently of enum declaration order.
        Comparator<Priority> businessOrder = Comparator.comparingInt(Priority::rank).reversed();
        System.out.println(values.stream().sorted(businessOrder).toList());
    }
}
