package level02_intermediate.jdk8.spliterator;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * {@code Spliterators} (plural) is a utility class of static factories that adapt existing
 * arrays/collections into a {@code Spliterator} without writing a class: {@code spliterator}
 * over an {@code Object[]} or a {@code Collection}, given a characteristics bitmask up front.
 * <p>Output: {@code 30} (5+10+15), then {@code XYZ}.
 */
public class Spliterator08SpliteratorsFactoryMethods {
    public static void main(String[] args) {
        Integer[] array = {5, 10, 15};
        Spliterator<Integer> fromArray =
                Spliterators.spliterator(array, Spliterator.ORDERED | Spliterator.IMMUTABLE);
        System.out.println(StreamSupport.stream(fromArray, false).mapToInt(Integer::intValue).sum());

        List<String> list = List.of("X", "Y", "Z");
        Spliterator<String> fromCollection =
                Spliterators.spliterator(list, Spliterator.ORDERED | Spliterator.SIZED);
        System.out.println(StreamSupport.stream(fromCollection, false).collect(Collectors.joining()));
    }
}
