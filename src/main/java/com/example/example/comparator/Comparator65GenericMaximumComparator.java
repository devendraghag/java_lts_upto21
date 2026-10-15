package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator65GenericMaximumComparator {
    record Job(String title, int urgency) {}

    // No Comparable bound is needed because the caller supplies the ordering rule.
    private static <T> T maximum(List<T> values, Comparator<? super T> order) {
        return values.stream().max(order).orElseThrow();
    }

    public static void main(String[] args) {
        List<Job> jobs = List.of(new Job("Email", 1), new Job("Incident", 5));
        System.out.println(maximum(jobs, Comparator.comparingInt(Job::urgency)));
        System.out.println(maximum(List.of("pear", "plum", "apple"),
                Comparator.comparingInt(String::length)));
    }
}
