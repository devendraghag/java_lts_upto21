package level03_advanced.jdk16.records;
// JDK history: Records were previewed in JDK 14 and 15, then finalized in JDK 16.


import java.util.HashMap;
import java.util.Map;

/**
 * Easy: Demonstrates Record18 Map Key Demo in the Records topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Analyze complexity, mutation during iteration, view behavior, and unsupported operations.
 */
record Coordinate(int x, int y) {}

public class Record18MapKeyDemo {
    public static void main(String[] args) {
        Map<Coordinate, String> map = new HashMap<>();

        map.put(new Coordinate(1, 2), "Point A");

        // Works because equals and hashCode are generated
        System.out.println(map.get(new Coordinate(1, 2)));
    }
}
