package com.example.aggregation;

import java.util.ArrayList;
import java.util.List;

/** A many-to-many association implemented as aggregation: people and projects are independent. */
public class Aggregation04ManyToManyProjects {
    public static void main(String[] args) {
        Person person = new Person("Lea");
        Project api = new Project("API");
        Project ui = new Project("UI");
        person.join(api);
        person.join(ui);
        api.addContributor(person);
        System.out.println(person.name + " projects: " + person.projects.stream().map(p -> p.name).toList());
        System.out.println(api.name + " contributors: " + api.contributors.stream().map(p -> p.name).toList());
    }

    private static final class Person {
        private final String name;
        private final List<Project> projects = new ArrayList<>();
        private Person(String name) { this.name = name; }
        private void join(Project project) { if (!projects.contains(project)) projects.add(project); }
    }
    private static final class Project {
        private final String name;
        private final List<Person> contributors = new ArrayList<>();
        private Project(String name) { this.name = name; }
        private void addContributor(Person person) { if (!contributors.contains(person)) contributors.add(person); }
    }
}
