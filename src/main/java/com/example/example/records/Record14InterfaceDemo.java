package level03_advanced.jdk16.records;
// JDK history: Records were previewed in JDK 14 and 15, then finalized in JDK 16.


/**
 * Easy: Demonstrates Record14 Interface Demo in the Records topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
interface Printable {
    void print();
}

record Report(String title) implements Printable {
    public void print() {
        System.out.println(title);
    }
}

public class Record14InterfaceDemo {
    public static void main(String[] args) {
        Report r = new Report("Annual Report");
        r.print();
    }
}
