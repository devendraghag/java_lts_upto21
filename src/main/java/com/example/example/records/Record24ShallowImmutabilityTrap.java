package level03_advanced.jdk16.records;
// JDK history: Records were previewed in JDK 14 and 15, then finalized in JDK 16.

import java.util.ArrayList;
import java.util.List;

/*
 * JDK 16 introduction-version bucket interview program: record shallow immutability trap.
 *
 * Interview point:
 * - A record's fields are final, but referenced mutable objects can still mutate.
 * - Defensive copying is needed for mutable components.
 */
/**
 * Easy: Demonstrates Record24 Shallow Immutability Trap in the Records topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Check canonical-constructor rules, equality semantics, and why record components provide only shallow immutability.
 */
public class Record24ShallowImmutabilityTrap {
    public static void main(String[] args) {
        List<String> skills = new ArrayList<String>();
        skills.add("Java");
        MutableRecordUserInterview user = new MutableRecordUserInterview(skills);
        skills.add("SQL");

        check(user.skills().size() == 2, "Record shallow immutability expected");
        System.out.println(user.skills());
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new IllegalStateException(message);
        }
    }
}

record MutableRecordUserInterview(List<String> skills) {
}
