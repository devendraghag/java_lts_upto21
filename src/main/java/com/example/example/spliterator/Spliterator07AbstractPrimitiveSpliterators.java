package level02_intermediate.jdk8.spliterator;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).

import java.util.Spliterators;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.stream.StreamSupport;

/**
 * The primitive counterparts to {@code Spliterators.AbstractSpliterator}:
 * {@code AbstractIntSpliterator}, {@code AbstractLongSpliterator}, and
 * {@code AbstractDoubleSpliterator} give the same size-estimate-driven {@code trySplit()}
 * default, but typed for {@code IntConsumer}/{@code LongConsumer}/{@code DoubleConsumer} so the
 * primitive stream never boxes. Compare against the manual {@code Spliterator.OfInt} etc.
 * implementations in {@code Spliterator05PrimitiveVariants} &mdash; only {@code tryAdvance}
 * differs here.
 * <p>Output: {@code 6}, {@code 6}, {@code 6.0}.
 */
public class Spliterator07AbstractPrimitiveSpliterators {

    static class IntRangeSpliterator extends Spliterators.AbstractIntSpliterator {
        private int current;
        private final int end;

        IntRangeSpliterator(int start, int end) {
            super(end - start, ORDERED | SIZED | IMMUTABLE);
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
    }

    static class LongRangeSpliterator extends Spliterators.AbstractLongSpliterator {
        private long current;
        private final long end;

        LongRangeSpliterator(long start, long end) {
            super(end - start, ORDERED | SIZED | IMMUTABLE);
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
    }

    static class DoubleRangeSpliterator extends Spliterators.AbstractDoubleSpliterator {
        private double current;
        private final double end;

        DoubleRangeSpliterator(double start, double end) {
            super((long) (end - start), ORDERED | IMMUTABLE);
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
    }

    public static void main(String[] args) {
        System.out.println(StreamSupport.intStream(new IntRangeSpliterator(1, 4), false).sum());
        System.out.println(StreamSupport.longStream(new LongRangeSpliterator(1L, 4L), false).sum());
        System.out.println(StreamSupport.doubleStream(new DoubleRangeSpliterator(1.0, 4.0), false).sum());
    }
}
