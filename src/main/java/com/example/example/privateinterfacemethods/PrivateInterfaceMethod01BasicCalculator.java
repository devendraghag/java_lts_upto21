package level03_advanced.jdk09.privateinterfacemethods;
// JDK history: Introduction baseline: JDK 9 (the release bucket for this topic).


/**
 * Easy: Demonstrates Private Interface Method01 Basic Calculator in the Private Interface Methods topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
interface Calculator {

    default void add(int a, int b) {
        displayResult(a + b);
    }

    default void subtract(int a, int b) {
        displayResult(a - b);
    }

    private void displayResult(int result) {
        System.out.println("Result: " + result);
    }
}

public class PrivateInterfaceMethod01BasicCalculator implements Calculator {
    public static void main(String[] args) {
        PrivateInterfaceMethod01BasicCalculator calc = new PrivateInterfaceMethod01BasicCalculator();
        calc.add(10, 5);
        calc.subtract(10, 5);
    }
}
