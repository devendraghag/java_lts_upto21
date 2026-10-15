package level03_advanced.jdk17.sealedclasses;
// JDK history: Sealed classes and interfaces were previewed in JDK 15 and 16, then finalized in JDK 17.

import java.util.Arrays;

/** Level 7: inspect sealed status and permitted subclasses at runtime. */
public class SealedClasses07Reflection {
    sealed interface Command permits Start, Stop { }

    record Start(String service) implements Command { }
    record Stop(String service) implements Command { }

    public static void main(String[] args) {
        Class<Command> type = Command.class;

        System.out.println("Is sealed: " + type.isSealed());
        Arrays.stream(type.getPermittedSubclasses())
                .map(Class::getSimpleName)
                .sorted()
                .forEach(System.out::println);
    }
}