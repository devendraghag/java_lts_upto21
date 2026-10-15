package level02_intermediate.jdk8.spliterator;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Trap: {@code characteristics()} is a self-reported promise, not something the JVM verifies.
 * This spliterator claims {@code IMMUTABLE} while {@code tryAdvance} reads directly from a
 * mutable backing array &mdash; nothing stops the array from changing mid-traversal, and the
 * spliterator happily reads the live (mutated) value. Code that trusts the {@code IMMUTABLE}
 * bit (e.g. to skip defensive copying or cache a result) would get a wrong answer here.
 * <p>Output: {@code first=A}, {@code second=MUTATED} (not {@code B}), {@code third=C}.
 */
public class Spliterator11CharacteristicsLieTrap {

    static class LyingImmutableSpliterator implements Spliterator<String> {
        private final String[] backing;
        private int index;
        private final int fence;

        LyingImmutableSpliterator(String[] backing) {
            this.backing = backing;
            this.index = 0;
            this.fence = backing.length;
        }

        @Override
        public boolean tryAdvance(Consumer<? super String> action) {
            if (index < fence) {
                action.accept(backing[index++]); // reads live array state, not a snapshot
                return true;
            }
            return false;
        }

        @Override
        public Spliterator<String> trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return fence - index;
        }

        @Override
        public int characteristics() {
            return ORDERED | SIZED | IMMUTABLE; // false promise: `backing` can still change
        }
    }

    public static void main(String[] args) {
        String[] data = {"A", "B", "C"};
        Spliterator<String> spliterator = new LyingImmutableSpliterator(data);

        spliterator.tryAdvance(v -> System.out.println("first=" + v));
        data[1] = "MUTATED";
        spliterator.tryAdvance(v -> System.out.println("second=" + v));
        spliterator.tryAdvance(v -> System.out.println("third=" + v));
    }
}
