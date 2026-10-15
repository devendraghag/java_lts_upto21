package level03_advanced.jdk14.switchexpressions;
// JDK history: Switch expressions were previewed in JDK 12 and 13, then finalized in JDK 14.

/*
 * JDK 14 introduction-version bucket interview program: switch expression yield block.
 *
 * Interview point:
 * - yield returns a value from a block-style switch case.
 * - Variables declared inside a case block stay scoped to that block.
 */
/**
 * Easy: Demonstrates Switch Expression06 Yield Scope Trap in the Switch Expressions topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Prove exhaustiveness and describe dominance, null handling, guards, and permitted-type restrictions.
 */
public class SwitchExpression06YieldScopeTrap {
    public static void main(String[] args) {
        String result = switch ("gold") {
            case "gold" -> {
                int discount = 20;
                yield "discount:" + discount;
            }
            default -> "discount:0";
        };

        check("discount:20".equals(result), "Switch yield mismatch");
        System.out.println(result);
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new IllegalStateException(message);
        }
    }
}
