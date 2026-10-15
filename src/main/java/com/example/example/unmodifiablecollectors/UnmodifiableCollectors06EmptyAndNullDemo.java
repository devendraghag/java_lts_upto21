package level03_advanced.jdk10.unmodifiablecollectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Level 06: handle empty input and learn the null behavior of both APIs. */
public class UnmodifiableCollectors06EmptyAndNullDemo {
    public static void main(String[] args) {
        List<String> empty = Stream.<String>empty()
                .collect(Collectors.toUnmodifiableList());
        System.out.println("Empty result size: " + empty.size());

        // toUnmodifiableList rejects null elements.
        try {
            Arrays.asList("Java", null).stream().collect(Collectors.toUnmodifiableList());
        } catch (NullPointerException exception) {
            System.out.println("Collectors.toUnmodifiableList rejects null");
        }

        // Stream.toList returns an unmodifiable list and can retain a null element.
        List<String> valuesWithNull = Stream.of("Java", null).toList();
        System.out.println("Stream.toList contains null: " + valuesWithNull.contains(null));
    }
}
