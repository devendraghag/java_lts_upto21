package com.example.example.sealedclasses;
// JDK history: Sealed classes and interfaces were previewed in JDK 15 and 16, then finalized in JDK 17.

/**
 * Level 3: every direct permitted subtype chooses how its own extension continues.
 */
public class SealedClasses03SubclassChoices {
    public static void main(String[] args) {
        Node[] nodes = {new Leaf("end"), new LeftBranch(), new RightBranch(),
                new OpenBranch(), new CustomBranch()};

        for (Node node : nodes) {
            System.out.println(node.getClass().getSimpleName());
        }
    }

    sealed interface Node permits Leaf, Branch, OpenBranch {
    }

    record Leaf(String value) implements Node {
    }

    sealed static class Branch implements Node permits LeftBranch, RightBranch {
    }

    static final class LeftBranch extends Branch {
    }

    static final class RightBranch extends Branch {
    }

    non-sealed static class OpenBranch implements Node {
    }

    static final class CustomBranch extends OpenBranch {
    }
}