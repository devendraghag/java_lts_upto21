package level03_advanced.jdk17.sealedclasses;
// JDK history: The final modifier was introduced in JDK 1.0. Records were previewed in JDK 14 and 15, then finalized in JDK 16; sealed types were previewed in JDK 15 and 16, then finalized in JDK 17.

/**
 * 15 - Modern Java connection (Java 17+): records are implicitly final;
 * sealed types restrict which classes may extend or implement them.
 */
public class SealedClasses12RecordsAndFinalModifier {
    sealed interface Payment permits CardPayment, CashPayment {
        String description();
    }

    // A permitted class may be final, sealed, or non-sealed.
    static final class CardPayment implements Payment {
        @Override
        public String description() {
            return "Card payment";
        }
    }

    // Records are implicitly final, so no 'final' modifier is written here.
    record CashPayment(int dollars) implements Payment {
        @Override
        public String description() {
            return "Cash payment: $" + dollars;
        }
    }

    public static void main(String[] args) {
        Payment card = new CardPayment();
        Payment cash = new CashPayment(25);
        System.out.println(card.description());
        System.out.println(cash.description());
    }
}
