package com.example.example.patternmatchingforswitch;

/** Level 12: handle enum constants and record patterns in one exhaustive sealed switch. */
public class PatternSwitch12EnumInSealedSwitch {
    sealed interface Command permits SystemCommand, SendMessage { }

    enum SystemCommand implements Command {
        START, STOP
    }

    record SendMessage(String recipient, String message) implements Command { }

    static String describe(Command command) {
        return switch (command) {
            case SystemCommand.START -> "Start the service";
            case SystemCommand.STOP -> "Stop the service";
            case SendMessage(var recipient, var message) ->
                    "Send '" + message + "' to " + recipient;
        };
    }

    public static void main(String[] args) {
        System.out.println(describe(SystemCommand.START));
        System.out.println(describe(new SendMessage("Asha", "Hello")));
    }
}
