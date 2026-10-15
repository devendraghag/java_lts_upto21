package com.example.association;

import java.util.ArrayList;
import java.util.List;

/** Demonstrates composition: a house creates and owns its rooms as parts. */
public class CompositionAssociationDemo {
    private static final class House {
        private final List<Room> rooms;

        private House(int roomCount) {
            rooms = new ArrayList<>();
            for (int number = 1; number <= roomCount; number++) {
                rooms.add(new Room("Room " + number));
            }
        }

        private void printRooms() {
            for (Room room : rooms) {
                System.out.println(room.name);
            }
        }
    }

    private static final class Room {
        private final String name;

        private Room(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        House house = new House(3);
        house.printRooms();
    }
}
