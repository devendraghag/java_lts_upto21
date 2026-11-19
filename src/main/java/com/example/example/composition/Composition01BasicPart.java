package com.example.composition;

/** A House creates and owns its Room; the part is not exposed independently. */
public class Composition01BasicPart {
    public static void main(String[] args) {
        House house = new House("12 Oak Street");
        house.describe();
    }
    private static final class House {
        private final String address;
        private final Room room;
        private House(String address) { this.address = address; this.room = new Room("Living room"); }
        private void describe() { System.out.println(address + " contains a " + room.name); }
    }
    private static final class Room {
        private final String name;
        private Room(String name) { this.name = name; }
    }
}
