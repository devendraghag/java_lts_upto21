package level02_intermediate.jdk8.spliterator;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).

import java.util.Spliterator;
import java.util.function.IntConsumer;
import java.util.stream.StreamSupport;

/**
 * Capstone: a paginated int source with a correct, balanced {@code trySplit()} (splits stop
 * once a chunk drops below a "page size" instead of splitting down to single elements), run
 * both sequentially and in parallel. Correct splitting means both paths must produce the exact
 * same aggregate &mdash; this is the same property real parallel-stream sources rely on.
 * <p>Output: {@code sum=5000050000} (sum of 1..100000), printed once both paths agree.
 */
public class Spliterator12Capstone {

    static class PagedIntSpliterator implements Spliterator.OfInt {
        private int start;
        private final int end;

        PagedIntSpliterator(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean tryAdvance(IntConsumer action) {
            if (start < end) {
                action.accept(start++);
                return true;
            }
            return false;
        }

        @Override
        public Spliterator.OfInt trySplit() {
            int remaining = end - start;
            if (remaining < 100) {
                return null; // below one "page": not worth splitting further
            }
            int mid = start + remaining / 2;
            Spliterator.OfInt prefix = new PagedIntSpliterator(start, mid);
            start = mid;
            return prefix;
        }

        @Override
        public long estimateSize() {
            return end - start;
        }

        @Override
        public int characteristics() {
            return ORDERED | SIZED | SUBSIZED | DISTINCT | IMMUTABLE;
        }
    }

    public static void main(String[] args) {
        long sequentialSum = StreamSupport.intStream(new PagedIntSpliterator(1, 100_001), false)
                .asLongStream().sum();
        long parallelSum = StreamSupport.intStream(new PagedIntSpliterator(1, 100_001), true)
                .asLongStream().sum();

        check(sequentialSum == parallelSum, "Sequential and parallel sums must match");
        System.out.println("sum=" + sequentialSum);
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new IllegalStateException(message);
        }
    }
}
