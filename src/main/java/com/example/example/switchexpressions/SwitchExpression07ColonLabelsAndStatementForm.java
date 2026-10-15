package level03_advanced.jdk14.switchexpressions;
// JDK history: Switch expressions were previewed in JDK 12 and 13, then finalized in JDK 14.

/**
 * Easy: Demonstrates Switch Expression07 Colon Labels And Statement Form in the Switch Expressions topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Prove exhaustiveness and describe dominance, null handling, guards, and permitted-type restrictions.
 */
public class SwitchExpression07ColonLabelsAndStatementForm {
    public static void main(String[] args) {
        int month = 2;

        String season;
        switch (month) {                 // statement form
            case 12:
            case 1:
            case 2:
                season = "winter";
                break;
            default:
                season = "other";
        }

        int days = switch (month) {      // expression form with colon labels
            case 2:
                yield 28;
            case 4:
            case 6:
            case 9:
            case 11:
                yield 30;
            default:
                yield 31;
        };

        System.out.println(season + ":" + days);
    }
}
