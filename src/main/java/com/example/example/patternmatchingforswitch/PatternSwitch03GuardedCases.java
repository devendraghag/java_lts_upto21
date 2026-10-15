package level03_advanced.jdk21.patternmatchingforswitch;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

/** Level 3: use when guards to refine a matching pattern. */
public class PatternSwitch03GuardedCases {
    static String classify(Object value) {
        return switch (value) {
            case String text when text.isBlank() -> "Blank text";
            case String text when text.length() < 5 -> "Short text";
            case String text -> "Text: " + text;
            case Integer number when number > 0 -> "Positive integer";
            case Integer number when number < 0 -> "Negative integer";
            case Integer number -> "Zero";
            default -> "Another type";
        };
    }

    public static void main(String[] args) {
        System.out.println(classify("  "));
        System.out.println(classify("Java"));
        System.out.println(classify(21));
        System.out.println(classify(0));
    }
}