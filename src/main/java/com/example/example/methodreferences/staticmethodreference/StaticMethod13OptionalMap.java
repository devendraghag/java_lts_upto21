package com.example.methodreferences.staticmethodreference;

import java.util.Optional;
import java.util.function.Function;

/** Harder: Optional.map accepts a Function that can point to a static conversion method. */
public class StaticMethod13OptionalMap {
    static class PriceParser {
        static Integer parseCents(String text) {
            return Integer.parseInt(text);
        }
    }

    public static void main(String[] args) {
        Function<String, Integer> lambda = text -> PriceParser.parseCents(text);
        Function<String, Integer> reference = PriceParser::parseCents;
        Optional<String> rawPrice = Optional.of("2599");

        System.out.println(rawPrice.map(lambda));
        System.out.println(rawPrice.map(reference));
    }
}
