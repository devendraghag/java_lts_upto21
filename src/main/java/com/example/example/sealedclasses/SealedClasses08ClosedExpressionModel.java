package level03_advanced.jdk17.sealedclasses;
// JDK history: Sealed classes and interfaces were previewed in JDK 15 and 16, then finalized in JDK 17.

/**
 * Level 8: model a closed expression family and process its known variants.
 * Pattern matching for instanceof is standard in Java 17; pattern switch was
 * only a preview feature in Java 17 and is intentionally not used here.
 */
public class SealedClasses08ClosedExpressionModel {
    sealed interface Expression permits NumberValue, Add { }

    record NumberValue(int value) implements Expression { }
    record Add(Expression left, Expression right) implements Expression { }

    static int evaluate(Expression expression) {
        if (expression instanceof NumberValue number) {
            return number.value();
        } else if (expression instanceof Add add) {
            return evaluate(add.left()) + evaluate(add.right());
        }

        // A future permitted subtype would need to be handled here.
        throw new IllegalStateException("Unhandled expression type");
    }

    public static void main(String[] args) {
        Expression expression =
                new Add(new NumberValue(10), new Add(new NumberValue(4), new NumberValue(3)));

        System.out.println(evaluate(expression)); // 17
    }
}