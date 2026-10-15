package level03_advanced.jdk21.patternmatchingforswitch;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

/** Level 4: handle null explicitly in a pattern switch. */
public class PatternSwitch04NullHandling {
    static String describe(Object value) {
        return switch (value) {
            case null -> "No value";
            case String text -> "Text: " + text;
            default -> "A different value";
        };
    }

    public static void main(String[] args) {
        System.out.println(describe(null));
        System.out.println(describe("Java"));
        System.out.println(describe(21));
    }
}