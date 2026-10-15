package com.example.comparable;

import java.util.Comparator;
import java.util.List;

public class Comparable14NullableRegionComparable {
    record Account(String region, int id) implements Comparable<Account> {
        private static final Comparator<String> REGION_ORDER =
                Comparator.nullsFirst(String::compareTo);

        @Override
        public int compareTo(Account other) {
            //comparator used with comparable
            int byRegion = REGION_ORDER.compare(region, other.region);
            // A null-safe field comparator prevents calling compareTo on a null region.
            return byRegion != 0 ? byRegion : Integer.compare(id, other.id);
        }
    }



    public static void main(String[] args) {
        List<Account> accounts = List.of(
                new Account("West", 3),
                new Account(null, 2),
                new Account("East", 4),
                new Account(null, 1));
        System.out.println(accounts.stream().sorted().toList());
    }
}
