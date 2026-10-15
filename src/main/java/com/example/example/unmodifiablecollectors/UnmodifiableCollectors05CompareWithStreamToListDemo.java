package level03_advanced.jdk10.unmodifiablecollectors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Level 05: compare Collectors.toUnmodifiableList() with Stream.toList() (Java 16+). */
public class UnmodifiableCollectors05CompareWithStreamToListDemo {
    public static void main(String[] args) {
        List<String> collectorResult = Stream.of("one", "two")
                .collect(Collectors.toUnmodifiableList()); // Java 10+
        List<String> streamResult = Stream.of("one", "two")
                .toList(); // Java 16+

        System.out.println("Same contents: " + collectorResult.equals(streamResult));
        showCannotAdd("Collectors.toUnmodifiableList", collectorResult);
        showCannotAdd("Stream.toList", streamResult);
    }

    private static void showCannotAdd(String source, List<String> values) {
        try {
            values.add("three");
        } catch (UnsupportedOperationException exception) {
            System.out.println(source + " returned an unmodifiable list");
        }
    }
}
