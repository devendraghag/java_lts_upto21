package com.example.association;

import java.util.List;

/** Demonstrates aggregation: teams refer to people whose lifetimes are independent. */
public class AggregationAssociationDemo {
    private record Player(String name) {
    }

    private record Team(String name, List<Player> players) {
        private Team {
            players = List.copyOf(players);
        }
    }

    public static void main(String[] args) {
        Player sharedPlayer = new Player("Jordan");
        Team redTeam = new Team("Red", List.of(sharedPlayer));
        Team blueTeam = new Team("Blue", List.of(sharedPlayer));

        System.out.println(redTeam.name() + " player: " + redTeam.players().get(0).name());
        System.out.println(blueTeam.name() + " player: " + blueTeam.players().get(0).name());
        System.out.println("Same independently created player: "
                + (redTeam.players().get(0) == blueTeam.players().get(0)));
    }
}
