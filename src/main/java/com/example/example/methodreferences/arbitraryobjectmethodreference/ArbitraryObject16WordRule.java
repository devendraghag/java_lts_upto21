package com.example.methodreferences.arbitraryobjectmethodreference;

import java.util.List;
import java.util.function.BiPredicate;

/** Hard: reusable domain logic receives its target as the method-reference receiver. */
public class ArbitraryObject16WordRule {
    record Word(String value) {
        boolean hasAtLeast(int minimumLength) {
            return value.length() >= minimumLength;
        }
    }

    public static void main(String[] args) {
        BiPredicate<Word, Integer> lambda = (word, length) -> word.hasAtLeast(length);
        BiPredicate<Word, Integer> reference = Word::hasAtLeast;
        List<Word> words = List.of(new Word("cat"), new Word("stream"));

        System.out.println(lambda.test(words.getFirst(), 3));
        System.out.println("At least 5 characters: "
                + words.stream().filter(word -> reference.test(word, 5)).toList());
    }
}
