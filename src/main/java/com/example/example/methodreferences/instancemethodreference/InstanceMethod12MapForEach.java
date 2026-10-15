package com.example.methodreferences.instancemethodreference;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.function.BiConsumer;

/** Harder: Map.forEach accepts BiConsumer, whose two inputs match this object method's arguments. */
public class InstanceMethod12MapForEach {
    static class EntryPrinter {
        void print(String key, Integer value) {
            System.out.println(key + " -> " + value);
        }
    }

    public static void main(String[] args) {
        EntryPrinter printer = new EntryPrinter();
        BiConsumer<String, Integer> lambda = (key, value) -> printer.print(key, value);
        BiConsumer<String, Integer> reference = printer::print;
        Map<String, Integer> scores = new LinkedHashMap<>();
        scores.put("Asha", 91);
        scores.put("Dev", 87);

        scores.forEach(lambda);
        System.out.println("Again through the method reference:");
        scores.forEach(reference);
    }
}
