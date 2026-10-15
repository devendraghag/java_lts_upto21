package com.example.helloworldways;

import java.util.Formatter;
import java.text.MessageFormat;
import static java.lang.System.out;

/** Several standard ways to produce the same Hello, World! text. */
public class HelloWorldWaysDemo {
    public static void main(String[] args) {
        // 1. The familiar println call.
        System.out.println("Hello, World! — println");

        // 2. print does not add a line terminator.
        System.out.print("Hello, World! — print\n");

        // 3. printf formats the message; %n is the platform line separator.
        System.out.printf("Hello, %s! — printf%n", "World");

        // 4. PrintStream.append can append characters and CharSequences.
        System.out.append("Hello, World! — append").append(System.lineSeparator());

        // 5. A static import lets the code refer to System.out as out.
        out.println("Hello, World! — static import");

        // 6. Build the text incrementally with StringBuilder.
        StringBuilder builder = new StringBuilder()
                .append("Hello, ").append("World!").append(" — StringBuilder");
        System.out.println(builder);

        // 7. MessageFormat substitutes indexed arguments.
        System.out.println(MessageFormat.format("Hello, {0}! — MessageFormat", "World"));

        // 8. Formatter writes formatted text into an Appendable.
        StringBuilder formatted = new StringBuilder();
        try (Formatter formatter = new Formatter(formatted)) {
            formatter.format("Hello, %s! — Formatter", "World");
        }
        System.out.println(formatted);

        // 9. A lambda can implement Runnable and be executed.
        Runnable lambdaGreeting = () -> System.out.println("Hello, World! — lambda");
        lambdaGreeting.run();

        // 10. A method reference can be used where Runnable is expected.
        Runnable referencedGreeting = HelloWorldWaysDemo::printGreeting;
        referencedGreeting.run();

        // 11. Reuse a helper method from the normal entry-point method.
        printGreeting();
    }

    private static void printGreeting() {
        System.out.println("Hello, World! — helper method");
    }
}
