package level03_advanced.jdk10.unmodifiablecollectors;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/** Level 03: create an unmodifiable map from stream values. */
public class UnmodifiableCollectors03MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> wordLengths = List.of("Java", "Stream", "Map").stream()
                .collect(Collectors.toUnmodifiableMap(Function.identity(), String::length));

        System.out.println(wordLengths);
        System.out.println("Length of Stream: " + wordLengths.get("Stream"));
    }
}
