package com.example.records;
// JDK history: Records were previewed in JDK 14 and 15, then finalized in JDK 16.


/**
 * Easy: Demonstrates Record01 Cannot Extend in the Records topic.
 * Inspect the commented example to see which usage the compiler rejects.
 * Medium: Identify the exact compiler rule before checking the commented invalid statement.
 * Tough: Explain the compile-time failure precisely, then state the smallest valid correction.
 */
record Base(int x) {}

// class Child extends Base {} ❌ NOT ALLOWED
// Records are implicitly final