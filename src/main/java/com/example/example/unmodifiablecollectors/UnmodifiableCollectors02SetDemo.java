package level03_advanced.jdk10.unmodifiablecollectors;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/** Level 02: collect values into an unmodifiable set and observe duplicate removal. */
public class UnmodifiableCollectors02SetDemo {
    public static void main(String[] args) {
        Set<String> languages = List.of("Java", "Java", "Kotlin", "Java").stream()
                .collect(Collectors.toUnmodifiableSet());

        System.out.println("Unique values: " + languages.size());
        System.out.println(languages);
        // A Set has no guaranteed encounter order; do not rely on the printed order.
    }
}
