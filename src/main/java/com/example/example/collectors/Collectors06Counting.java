package com.example.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class Collectors06Counting {
    public static void main(String[] args) {
        List<String> names = List.of("Asha", "Ravi", "Mina");

        long count = names.stream().collect(Collectors.counting());

        System.out.println("number of names = " + count);
    }
}
