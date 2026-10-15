package level02_intermediate.jdk8.spliterator;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).

import java.util.Spliterator;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.StreamSupport;

/**
 * {@code Spliterator.OfInt}/{@code OfLong}/{@code OfDouble} are the primitive specializations
 * of {@code Spliterator.OfPrimitive}: {@code tryAdvance} takes an {@code IntConsumer}/
 * {@code LongConsumer}/{@code DoubleConsumer} instead of a boxing {@code Consumer<T>}, so a
 * hand-written numeric source can feed {@code IntStream}/{@code LongStream}/{@code DoubleStream}
 * without ever boxing an element.
 * <p>Output: {@code 6} (ints 1+2+3), {@code 6} (longs 1+2+3), {@code 6.0} (doubles 1.0+2.0+3.0).
 */
public class Spliterator05PrimitiveVariants {

    static class IntCounterSpliterator implements Spliterator.OfInt {
        private int current;
        private final int end;

        IntCounterSpliterator(int start, int end) {
            this.current = start;
            this.end = end;
        }

        @Override
        public boolean tryAdvance(IntConsumer action) {
            if (current < end) {
                action.accept(current++);
                return true;
            }
            return false;
        }

        @Override
        public Spliterator.OfInt trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return end - current;
        }

        @Override
        public int characteristics() {
            return ORDERED | SIZED | IMMUTABLE;
        }
    }

    static class LongCounterSpliterator implements Spliterator.OfLong {
        private long current;
        private final long end;

        LongCounterSpliterator(long start, long end) {
            this.current = start;
            this.end = end;
        }

        @Override
        public boolean tryAdvance(LongConsumer action) {
            if (current < end) {
                action.accept(current++);
                return true;
            }
            return false;
        }

        @Override
        public Spliterator.OfLong trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return end - current;
        }

        @Override
        public int characteristics() {
            return ORDERED | SIZED | IMMUTABLE;
        }
    }

    static class DoubleCounterSpliterator implements Spliterator.OfDouble {
        private double current;
        private final double end;

        DoubleCounterSpliterator(double start, double end) {
            this.current = start;
            this.end = end;
        }

        @Override
        public boolean tryAdvance(DoubleConsumer action) {
            if (current < end) {
                action.accept(current);
                current += 1.0;
                return true;
            }
            return false;
        }

        @Override
        public Spliterator.OfDouble trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return (long) ((end - current) / 1.0);
        }

        @Override
        public int characteristics() {
            return ORDERED | IMMUTABLE;
        }
    }

    public static void main(String[] args) {
        IntStream ints = StreamSupport.intStream(new IntCounterSpliterator(1, 4), false);
        System.out.println(ints.sum());

        LongStream longs = StreamSupport.longStream(new LongCounterSpliterator(1L, 4L), false);
        System.out.println(longs.sum());

        DoubleStream doubles = StreamSupport.doubleStream(new DoubleCounterSpliterator(1.0, 4.0), false);
        System.out.println(doubles.sum());
    }
}
