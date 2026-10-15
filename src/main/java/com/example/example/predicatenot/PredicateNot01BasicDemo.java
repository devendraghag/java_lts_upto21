package level03_advanced.jdk11.predicatenot;


import java.util.List;
import java.util.function.Predicate;

/*
 * JDK 11 introduction-version bucket feature: Predicate.not().
 *
 * Predicate.not() improves readability when filtering the opposite of a
 * method reference or predicate.
 */
/**
 * Easy: Demonstrates Predicate Not01 Basic Demo in the Predicate Not topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class PredicateNot01BasicDemo {
    public static void main(String[] args) {
        List<String> names = List.of("Amit", "", "Riya", "   ", "Dev");

        names.stream()
                .filter(Predicate.not(String::isBlank))
                .forEach(System.out::println);
    }
}

