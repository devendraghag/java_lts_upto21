package com.example.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class Collectors05Joining {
    public static void main(String[] args) {
        List<String> names = List.of("Asha", "Ravi", "Mina");

        String joined = names.stream()
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(joined);
    }
}
