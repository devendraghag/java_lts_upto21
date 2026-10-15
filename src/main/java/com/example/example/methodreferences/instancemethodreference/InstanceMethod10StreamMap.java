package com.example.methodreferences.instancemethodreference;

import java.util.List;
import java.util.function.Function;

/** Medium: map uses a Function that calls a method on one formatter instance. */
public class InstanceMethod10StreamMap {
    static class Formatter {
        String addLabel(String value) {
            return "item=" + value;
        }
    }

    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        List<String> values = List.of("A", "B", "C");
        Function<String, String> lambda = value -> formatter.addLabel(value);
        Function<String, String> reference = formatter::addLabel;

        System.out.println(values.stream().map(lambda).toList());
        System.out.println(values.stream().map(reference).toList());
    }
}
