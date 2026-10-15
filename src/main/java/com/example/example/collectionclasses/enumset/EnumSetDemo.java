package com.example.collectionclasses.enumset;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class EnumSetDemo {
    private enum Permission { READ, WRITE, DELETE }

    public static void main(String[] args) {
        EnumSet<Permission> permissions = EnumSet.of(Permission.READ, Permission.WRITE);
        permissions.add(Permission.DELETE);
        permissions.remove(Permission.WRITE);
        permissions.addAll(EnumSet.of(Permission.READ));

        for (Permission permission : permissions) {
            System.out.println(permission);
        }

        EnumSet<Permission> all = EnumSet.allOf(Permission.class);
        System.out.println("All permissions: " + all);
        System.out.println("ArrayList conversion: " + new ArrayList<>(permissions));
        List<Permission> list = List.copyOf(permissions);
        System.out.println("Immutable list conversion: " + list);
        System.out.println("Contains READ: " + permissions.contains(Permission.READ));
        System.out.println("Complement of permissions: " + EnumSet.complementOf(permissions));
        System.out.println("Range READ through WRITE: " + EnumSet.range(Permission.READ, Permission.WRITE));
        permissions.clear(); // Removes every enum constant from this set.
        System.out.println("Empty after clear: " + permissions.isEmpty());
        // EnumSet iterates in enum declaration order; it is not a SequencedSet API type.
    }
}
