package com.example.intermediateoperations;

import java.util.List;
import java.util.function.Predicate;

/** Easy: filter is intermediate; toList triggers pipeline execution. */
public class IntermediatePractice01FilterBasics {
    public static void main(String[] args) {
        List<String> names = List.of("Asha", "Ben", "Amit", "Mina");
        Predicate<String> lambda = name -> name.startsWith("A");
        System.out.println(names.stream().filter(lambda).toList());
        System.out.println(names.stream().filter(IntermediatePractice01FilterBasics::startsWithA).toList());
    }

    private static boolean startsWithA(String name) {
        return name.startsWith("A");
    }
}