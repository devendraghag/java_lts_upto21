package level03_advanced.jdk16.records;
// JDK history: Records were previewed in JDK 14 and 15, then finalized in JDK 16.


/**
 * Easy: Demonstrates Record11 Full Constructor Demo in the Records topic.
 * Run it to observe the basic behavior and output.
 * Medium: Predict initialization and method dispatch using the declared type and the runtime object type.
 * Tough: Separate compile-time selection from runtime dispatch and account for hiding, initialization order, and access rules.
 */
record Product(String name, double price) {

    // Full constructor
    public Product(String name, double price) {
        this.name = name.toUpperCase(); // modify input
        this.price = price;
    }
}

public class Record11FullConstructorDemo {
    public static void main(String[] args) {
        Product p = new Product("laptop", 70000);
        System.out.println(p); // name is uppercase
    }
}
