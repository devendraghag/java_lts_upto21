package level03_advanced.jdk10.unmodifiablecollectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** Level 04: handle repeated map keys with the merge-function overload. */
public class UnmodifiableCollectors04DuplicateKeysDemo {
    public static void main(String[] args) {
        List<String> words = List.of("ant", "apple", "axe", "berry", "boat");

        // Several words start with the same letter, so the key is not unique.
        // Integer::sum tells the collector how to combine values for duplicate keys.
        Map<Character, Integer> wordsPerFirstLetter = words.stream()
                .collect(Collectors.toUnmodifiableMap(
                        word -> word.charAt(0),
                        word -> 1,
                        Integer::sum));

        System.out.println(wordsPerFirstLetter);
        // Without a merge function, duplicate keys cause IllegalStateException.
    }
}
