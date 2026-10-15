package com.example.functionalinterfaces.supplierinterfaces;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/** Pattern 12: generate a stream of values from a Supplier. */
public class SupplierPattern12_StreamGeneration {
    public static void main(String[] args) {
        Random random = new Random(42);
        Supplier<Integer> diceRoll = () -> random.nextInt(6) + 1;

        Stream.generate(diceRoll).limit(5).forEach(System.out::println);
    }
}