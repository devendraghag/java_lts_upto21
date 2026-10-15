package com.example.comparable;

import java.util.List;

public class Comparable13UserNameComparable {
    record UserName(String value) implements Comparable<UserName> {
        @Override
        public int compareTo(UserName other) {
            int byIgnoringCase = value.compareToIgnoreCase(other.value);
            // Exact spelling is a tie-breaker so SAM, Sam, and sam remain distinct in sorted sets.
            return byIgnoringCase != 0 ? byIgnoringCase : value.compareTo(other.value);
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public static void main(String[] args) {
        List<UserName> names = List.of(
                new UserName("sam"),
                new UserName("SAM"),
                new UserName("Sam"));
        System.out.println(names.stream().sorted().toList());
    }
}
