package com.example.association;

import java.util.ArrayList;
import java.util.List;

/** Maintains both sides of a many-to-many association through one method. */
public class Association03BidirectionalManyToMany {
    public static void main(String[] args) {
        Member member = new Member("Kai");
        Club chess = new Club("Chess");
        Club robotics = new Club("Robotics");
        member.join(chess);
        member.join(robotics);
        System.out.println(member.name + " clubs: " + member.clubs.stream().map(c -> c.name).toList());
        System.out.println(chess.name + " members: " + chess.members.stream().map(m -> m.name).toList());
    }
    private static final class Member {
        private final String name;
        private final List<Club> clubs = new ArrayList<>();
        private Member(String name) { this.name = name; }
        private void join(Club club) {
            if (!clubs.contains(club)) { clubs.add(club); club.addMember(this); }
        }
    }
    private static final class Club {
        private final String name;
        private final List<Member> members = new ArrayList<>();
        private Club(String name) { this.name = name; }
        private void addMember(Member member) { if (!members.contains(member)) members.add(member); }
    }
}
