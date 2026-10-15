package com.example.coupling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

import java.util.ArrayList;
import java.util.List;

/**
 * Content coupling: one class directly reaches into another class's internal
 * data instead of using that class's operations. This same-package example is
 * deliberately poor design so the dependency is visible.
 */
public class CouplingType06Content {
    public static void main(String[] args) {
        UserRepository repository = new UserRepository();
        repository.add("Mina");
        repository.add("Ravi");

        System.out.println("Users before cleanup: " + repository.size());
        new EmergencyCleanup().deleteAll(repository);
        System.out.println("Users after cleanup: " + repository.size());
    }
}

// Package-private field: other classes in this package can directly access it.
class UserRepository {
    final List<String> users = new ArrayList<String>();

    void add(String name) {
        users.add(name);
    }

    int size() {
        return users.size();
    }
}

class EmergencyCleanup {
    void deleteAll(UserRepository repository) {
        // Bypasses UserRepository's methods and modifies its internal collection.
        repository.users.clear();
    }
}
