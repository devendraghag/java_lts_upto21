package level03_advanced.jdk21.patternmatchingforswitch;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

/** Level 5: put a more specific type pattern before its supertype pattern. */
public class PatternSwitch05CaseOrdering {
    static String describe(Object value) {
        return switch (value) {
            case String text -> "String: " + text;
            case CharSequence sequence -> "Other character sequence: " + sequence;
            default -> "Not a character sequence";
        };
    }

    public static void main(String[] args) {
        System.out.println(describe("Java"));
        System.out.println(describe(new StringBuilder("Builder")));
        System.out.println(describe(21));
    }
}