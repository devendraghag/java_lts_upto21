package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator36NullableRegionComparator {
    record Account(String region, int id) {}

    public static void main(String[] args) {
        List<Account> accounts = List.of(
                new Account("West", 3),
                new Account(null, 2),
                new Account("East", 4),
                new Account(null, 1));

        // nullsFirst protects the extracted String key; id orders accounts with the same region.
        Comparator<Account> order = Comparator
                .comparing(Account::region, Comparator.nullsFirst(String::compareTo))
                .thenComparingInt(Account::id);
        System.out.println(accounts.stream().sorted(order).toList());
    }
}
