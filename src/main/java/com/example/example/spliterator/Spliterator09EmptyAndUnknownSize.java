package level02_intermediate.jdk8.spliterator;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

/**
 * Two more {@code Spliterators} factories for edge cases: {@code emptySpliterator()} for a
 * source with nothing in it, and {@code spliteratorUnknownSize(Iterator, characteristics)} for
 * adapting a legacy {@code Iterator} whose size can't be known up front (its
 * {@code estimateSize()} always reports {@code Long.MAX_VALUE} until proven otherwise).
 * <p>Output: {@code empty count=0}, {@code adapted estimateSize=9223372036854775807},
 * {@code adapted sum=6}.
 */
public class Spliterator09EmptyAndUnknownSize {
    public static void main(String[] args) {
        Spliterator<String> empty = Spliterators.emptySpliterator();
        System.out.println("empty count=" + StreamSupport.stream(empty, false).count());

        Iterator<Integer> legacyIterator = List.of(1, 2, 3).iterator();
        Spliterator<Integer> adapted = Spliterators.spliteratorUnknownSize(legacyIterator, Spliterator.ORDERED);
        System.out.println("adapted estimateSize=" + adapted.estimateSize());
        System.out.println("adapted sum=" + StreamSupport.stream(adapted, false).mapToInt(Integer::intValue).sum());
    }
}
