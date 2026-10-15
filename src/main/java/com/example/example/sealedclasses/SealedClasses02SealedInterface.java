package level03_advanced.jdk17.sealedclasses;
// JDK history: Sealed classes and interfaces were previewed in JDK 15 and 16, then finalized in JDK 17.

/** Level 2: interfaces can also restrict which types implement them. */
public class SealedClasses02SealedInterface {
    sealed interface Payment permits CardPayment, CashPayment { }

    record CardPayment(String lastFourDigits) implements Payment { }
    record CashPayment(int amountInCents) implements Payment { }

    public static void main(String[] args) {
        Payment card = new CardPayment("1234");
        Payment cash = new CashPayment(2500);

        System.out.println(card);
        System.out.println(cash);
    }
}