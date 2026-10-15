package level03_advanced.jdk09.privateinterfacemethods;
// JDK history: Introduction baseline: JDK 9 (the release bucket for this topic).


/**
 * Easy: Demonstrates Private Interface Method03 Payment Logger in the Private Interface Methods topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
interface PaymentProcessor {

    default void processPayment(double amount) {
        log("Processing payment of $" + amount);
        System.out.println("Payment of $" + amount + " completed.");
    }

    default void refundPayment(double amount) {
        log("Processing refund of $" + amount);
        System.out.println("Refund of $" + amount + " completed.");
    }

    private void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}

public class PrivateInterfaceMethod03PaymentLogger implements PaymentProcessor {
    public static void main(String[] args) {
        PrivateInterfaceMethod03PaymentLogger app = new PrivateInterfaceMethod03PaymentLogger();
        app.processPayment(150.00);
        app.refundPayment(50.00);
    }
}
