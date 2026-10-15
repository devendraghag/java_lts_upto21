package level03_advanced.jdk10.unmodifiablecollectors;

import java.util.List;
import java.util.stream.Collectors;

/** Level 01: collect a stream into an unmodifiable list. */
public class UnmodifiableCollectors01ListDemo {
    public static void main(String[] args) {
        // The collector keeps the stream's encounter order.
        List<String> names = List.of("Asha", "Ravi", "Mina").stream()
                .collect(Collectors.toUnmodifiableList());

        System.out.println(names);
        try {
            names.add("Noor"); // The returned list cannot be changed.
        } catch (UnsupportedOperationException exception) {
            System.out.println("The collected list is unmodifiable");
        }
    }
}
