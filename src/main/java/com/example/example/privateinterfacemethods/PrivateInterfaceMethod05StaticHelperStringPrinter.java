package level03_advanced.jdk09.privateinterfacemethods;
// JDK history: Introduction baseline: JDK 9 (the release bucket for this topic).


/**
 * Easy: Demonstrates Private Interface Method05 Static Helper String Printer in the Private Interface Methods topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
interface StringUtil {

    static void printUpper(String str) {
        printFormatted(str.toUpperCase());
    }

    static void printLower(String str) {
        printFormatted(str.toLowerCase());
    }

    private static void printFormatted(String str) {
        System.out.println("Formatted: " + str);
    }
}

public class PrivateInterfaceMethod05StaticHelperStringPrinter {
    public static void main(String[] args) {
        StringUtil.printUpper("Hello World");
        StringUtil.printLower("Hello World");
    }
}
