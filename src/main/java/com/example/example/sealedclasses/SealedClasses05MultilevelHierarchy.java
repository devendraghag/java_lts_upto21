package level03_advanced.jdk17.sealedclasses;
// JDK history: Sealed classes and interfaces were previewed in JDK 15 and 16, then finalized in JDK 17.

/** Level 5: sealed hierarchies can control extension at multiple levels. */
public class SealedClasses05MultilevelHierarchy {
    sealed interface Expression permits NumberValue, BinaryExpression { }

    record NumberValue(int value) implements Expression { }

    sealed interface BinaryExpression extends Expression permits Add, Multiply { }

    record Add(Expression left, Expression right) implements BinaryExpression { }
    record Multiply(Expression left, Expression right) implements BinaryExpression { }

    public static void main(String[] args) {
        Expression expression =
                new Add(new NumberValue(2),
                        new Multiply(new NumberValue(3), new NumberValue(4)));

        System.out.println(expression);
    }
}