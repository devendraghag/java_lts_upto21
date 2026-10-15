package level03_advanced.jdk21.patternmatchingforswitch;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

/** Level 2: return a value from a switch expression using type patterns. */
public class PatternSwitch02SwitchExpression {
    static String describe(Object value) {
        return switch (value) {
            case String text -> "String: " + text;
            case Integer number -> "Integer: " + number;
            case Boolean flag -> "Boolean: " + flag;
            default -> "Other value";
        };
    }

    public static void main(String[] args) {
        System.out.println(describe("Java"));
        System.out.println(describe(21));
        System.out.println(describe(true));
    }
}