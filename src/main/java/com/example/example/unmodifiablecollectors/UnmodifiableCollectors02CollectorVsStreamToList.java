package level03_advanced.jdk10.unmodifiablecollectors;

import java.util.List;
import java.util.stream.Collectors;

/** Compatibility example for older IDE run configurations; compares both unmodifiable list APIs. */
public class UnmodifiableCollectors02CollectorVsStreamToList {
    public static void main(String[] args) {
        List<String> collectorList = List.of("a", "b").stream()
                .collect(Collectors.toUnmodifiableList());
        List<String> streamList = List.of("a", "b").stream().toList();

        System.out.println("Same contents: " + collectorList.equals(streamList));
        System.out.println("Collector result: " + collectorList);
        System.out.println("Stream.toList result: " + streamList);
    }
}
