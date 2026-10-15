package level02_intermediate.jdk8.spliterator;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * A minimal hand-written {@code Spliterator<T>} over a backing array, wired into
 * {@code StreamSupport.stream(...)} to produce a real {@code Stream}. This is the mechanism
 * every JDK collection's {@code .stream()} ultimately relies on: implement {@code tryAdvance},
 * {@code trySplit}, {@code estimateSize}, and {@code characteristics}, and the whole
 * {@code Stream} API works on top of it for free.
 * <p>Output: {@code A,B,C}.
 */
public class Spliterator03CustomSpliteratorBasic {

    static class ArraySpliterator<T> implements Spliterator<T> {
        private final T[] array;
        private int index;
        private final int fence;

        ArraySpliterator(T[] array, int index, int fence) {
            this.array = array;
            this.index = index;
            this.fence = fence;
        }

        @Override
        public boolean tryAdvance(Consumer<? super T> action) {
            if (index < fence) {
                action.accept(array[index++]);
                return true;
            }
            return false;
        }

        @Override
        public Spliterator<T> trySplit() {
            return null; // not splittable in this basic version, see Spliterator04TrySplit
        }

        @Override
        public long estimateSize() {
            return fence - index;
        }

        @Override
        public int characteristics() {
            return ORDERED | SIZED | IMMUTABLE;
        }
    }

    public static void main(String[] args) {
        String[] data = {"A", "B", "C"};
        Spliterator<String> spliterator = new ArraySpliterator<>(data, 0, data.length);

        Stream<String> stream = StreamSupport.stream(spliterator, false);
        System.out.println(stream.collect(Collectors.joining(",")));
    }
}
