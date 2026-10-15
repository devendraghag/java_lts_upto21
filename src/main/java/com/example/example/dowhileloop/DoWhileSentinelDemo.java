package com.example.dowhileloop;

/** Reads values until a sentinel value is encountered. */
public class DoWhileSentinelDemo {
    public static void main(String[] args) {
        int[] values = {5, 8, 3, -1, 100};
        int index = 0;
        int value;
        long total = 0;

        do {
            value = values[index++];
            if (value != -1) {
                total += value;
            }
        } while (value != -1); // -1 is the sentinel and is not included in the total.

        System.out.println("Values before sentinel total: " + total);
        System.out.println("Values read: " + index);
    }
}
