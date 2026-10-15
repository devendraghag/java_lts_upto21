package com.example.objectclass;

/** Object.clone() is shallow; a copy constructor can create an independent copy. */
public class ObjectCloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Profile original = new Profile("Mina", "initial");
        Profile shallowCopy = original.clone();
        shallowCopy.appendNote(" + shared mutation");
        System.out.println("Original after shallow clone mutation: " + original.notes());

        Profile independentCopy = new Profile(original);
        independentCopy.appendNote(" + independent mutation");
        System.out.println("Original after copy constructor: " + original.notes());
        System.out.println("Independent copy: " + independentCopy.notes());
    }

    private static class Profile implements Cloneable {
        private final String name;
        private final StringBuilder notes;

        Profile(String name, String notes) {
            this.name = name;
            this.notes = new StringBuilder(notes);
        }

        Profile(Profile source) {
            this(source.name, source.notes.toString());
        }

        @Override
        public Profile clone() throws CloneNotSupportedException {
            return (Profile) super.clone(); // Cloneable allows Object.clone() to proceed.
        }

        void appendNote(String text) { notes.append(text); }
        String notes() { return name + ": " + notes; }
    }
}
