package org.example.lts_features.level03_advanced.jdk16.records;
// JDK history: Records were previewed in JDK 14 and 15, then finalized in JDK 16.

/**
 * Easy: Demonstrates Record25 Generic Record in the Records topic.
 * Run it to observe the basic behavior and output.
 * Medium: Check the compile-time type guarantees, conversions, and the value observed at runtime.
 * Tough: Explain erasure, variance, bridge methods, heap-pollution risk, and any unchecked conversion.
 */
public class Record25GenericRecord {
    record Pair<K, V>(K key, V value) {
    }

    public static void main(String[] args) {
        Pair<String, Integer> score = new Pair<>("Java", 16);
        System.out.println(score.key() + ":" + score.value());
    }
}