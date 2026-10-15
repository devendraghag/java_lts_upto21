package level03_advanced.jdk16.records.comparablerecord;
// JDK history: Records were previewed in JDK 14 and 15, then finalized in JDK 16.


/**
 * Easy: Demonstrates Employee5 in the Records / Comparable Record topic.
 * Use this type with its related example to observe the basic behavior.
 * Medium: Track element order, duplicates, lookup behavior, and the collection state after each operation.
 * Tough: Check whether comparison is transitive, null-safe, and consistent with equals.
 */
public record Employee5(int id,String name)
        implements Comparable<Employee5>{
    public int compareTo(Employee5 o){
        return Integer.compare(this.id(),o.id());
    }
}
