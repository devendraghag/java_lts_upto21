package com.example.aggregation;

import java.util.List;

/** Contrasts shared aggregation with an owner-created composition example. */
public class AggregationVsCompositionDemo {
    public static void main(String[] args) {
        Player player = new Player("Kai");
        Team redTeam = new Team("Red", List.of(player));
        Team blueTeam = new Team("Blue", List.of(player));
        System.out.println(redTeam.name + " and " + blueTeam.name
                + " both reference player " + player.name);

        House house = new House("Willow Cottage");
        System.out.println(house.description());
    }

    private record Player(String name) { }

    private record Team(String name, List<Player> players) {
        private Team {
            players = List.copyOf(players);
        }
    }

    private static final class House {
        private final String name;
        private final List<Room> rooms;

        private House(String name) {
            this.name = name;
            // Rooms are created and owned internally in this composition-style design.
            this.rooms = List.of(new Room("Kitchen"), new Room("Bedroom"));
        }

        private String description() {
            return name + " contains " + rooms.size() + " rooms: " + rooms;
        }
    }

    private record Room(String name) { }
}
