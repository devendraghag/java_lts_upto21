package level03_advanced.jdk11.localvariabletypeinference.varinlambdaparameters;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


import java.util.List;

/**
 * Easy: Demonstrates Var Lambda Parameter03 Single Param Stream Filter in the Local Variable Type Inference / Var In Lambda Parameters topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class VarLambdaParameter03SingleParamStreamFilter {

    public static void main(String[] args) {

        List<String> usernames = List.of("admin", "user", "guest");

        // Filter usernames with length > 4
        // 'var' works normally in stream operations
        usernames.stream()
                 .filter((var u) -> u.length() > 4)
                 .forEach(System.out::println);
    }
}
