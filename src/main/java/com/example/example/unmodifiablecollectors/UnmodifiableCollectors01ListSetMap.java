package level03_advanced.jdk10.unmodifiablecollectors;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/** Compatibility example for older IDE run configurations; demonstrates all three collectors. */
public class UnmodifiableCollectors01ListSetMap {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B").stream()
                .collect(Collectors.toUnmodifiableList());
        Set<String> set = List.of("A", "A", "B").stream()
                .collect(Collectors.toUnmodifiableSet());
        Map<String, Integer> map = List.of("java", "sql").stream()
                .collect(Collectors.toUnmodifiableMap(Function.identity(), String::length));

        System.out.println("List: " + list);
        System.out.println("Unique set values: " + set);
        System.out.println("Word lengths: " + map);
    }
}
