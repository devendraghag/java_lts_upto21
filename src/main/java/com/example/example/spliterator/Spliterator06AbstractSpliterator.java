package level02_intermediate.jdk8.spliterator;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * {@code Spliterators.AbstractSpliterator<T>} supplies working (if size-estimate-driven)
 * defaults for {@code trySplit()} and {@code estimateSize()}, so a source that doesn't need
 * custom splitting logic only has to implement {@code tryAdvance()} &mdash; far less boilerplate
 * than {@code Spliterator03CustomSpliteratorBasic}'s from-scratch implementation.
 * <p>Output: {@code Quick Brown Fox}.
 */
public class Spliterator06AbstractSpliterator {

    static class WordSpliterator extends Spliterators.AbstractSpliterator<String> {
        private final String[] words;
        private int index;

        WordSpliterator(String[] words) {
            super(words.length, ORDERED | SIZED | IMMUTABLE);
            this.words = words;
        }

        @Override
        public boolean tryAdvance(Consumer<? super String> action) {
            if (index < words.length) {
                action.accept(words[index++]);
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String[] words = {"Quick", "Brown", "Fox"};

        Stream<String> stream = StreamSupport.stream(new WordSpliterator(words), false);
        System.out.println(stream.collect(Collectors.joining(" ")));
    }
}
