package level03_advanced.jdk16.streamtolist;


import java.util.Arrays;
import java.util.List;

/*
 * JDK 16 introduction-version bucket feature bucket: Stream.toList().
 *
 * Stream.toList() was introduced before JDK 17 and is available in JDK 16 introduction-version bucket.
 * It is a concise alternative to collect(Collectors.toList()).
 */
/**
 * Easy: Demonstrates Stream To List01 Basic Demo in the Stream To List topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class StreamToList01BasicDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("amit", "riya", "dev");

        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(upperCaseNames);
    }
}

