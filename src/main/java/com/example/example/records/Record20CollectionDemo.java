package level03_advanced.jdk16.records;
// JDK history: Records were previewed in JDK 14 and 15, then finalized in JDK 16.


import java.util.List;

/**
 * Easy: Demonstrates Record20 Collection Demo in the Records topic.
 * Run it to observe the basic behavior and output.
 * Medium: Track element order, duplicates, lookup behavior, and the collection state after each operation.
 * Tough: Analyze complexity, mutation during iteration, view behavior, and unsupported operations.
 */
record Order(int id, double amount) {}

public class Record20CollectionDemo {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, 1000),
                new Order(2, 5000)
        );

        for (Order o : orders) {
            System.out.println(o);
        }
    }
}
