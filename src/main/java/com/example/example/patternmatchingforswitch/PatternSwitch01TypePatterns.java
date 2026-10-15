package level03_advanced.jdk21.patternmatchingforswitch;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

/** Level 1: match different runtime types with switch pattern labels. */
public class PatternSwitch01TypePatterns {
    public static void main(String[] args) {
        Object value = 42;

        switch (value) {
            case String text -> System.out.println("Text length: " + text.length());
            case Integer number -> System.out.println("Integer doubled: " + (number * 2));
            default -> System.out.println("Another type");
        }
    }
}