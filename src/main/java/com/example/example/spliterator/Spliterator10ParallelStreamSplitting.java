package level02_intermediate.jdk8.spliterator;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.StreamSupport;

/**
 * A parallel stream doesn't magically parallelize &mdash; {@code StreamSupport.stream(sp, true)}
 * repeatedly calls {@code trySplit()} on the source spliterator to hand independent chunks to
 * the common {@code ForkJoinPool}, only stopping once a chunk is small/unsplittable. This
 * logs every real {@code trySplit()} call so the splitting is visible instead of implicit.
 * <p>Output includes one or more {@code trySplit: splitting [...]} lines (exact count depends
 * on the JVM's common-pool parallelism) followed by {@code total=120} (sum of 0..15).
 */
public class Spliterator10ParallelStreamSplitting {

    static class LoggingRangeSpliterator implements Spliterator<Integer> {
        private int start;
        private final int end;

        LoggingRangeSpliterator(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean tryAdvance(Consumer<? super Integer> action) {
            if (start < end) {
                action.accept(start++);
                return true;
            }
            return false;
        }

        @Override
        public Spliterator<Integer> trySplit() {
            int remaining = end - start;
            if (remaining < 2) {
                return null;
            }
            int mid = start + remaining / 2;
            System.out.println("trySplit: splitting [" + start + "," + end + ") at " + mid);
            Spliterator<Integer> prefix = new LoggingRangeSpliterator(start, mid);
            start = mid;
            return prefix;
        }

        @Override
        public long estimateSize() {
            return end - start;
        }

        @Override
        public int characteristics() {
            return ORDERED | SIZED | SUBSIZED;
        }
    }

    public static void main(String[] args) {
        int total = StreamSupport.stream(new LoggingRangeSpliterator(0, 16), true)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("total=" + total);
    }
}
