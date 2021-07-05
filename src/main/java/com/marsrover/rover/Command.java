package com.marsrover.rover;

import java.util.stream.Stream;

public enum Command {

    FORWARD('F'),
    BACKWARD('B'),
    LEFT('L'),
    RIGHT('R');

    private final char command;

    Command(char command) {
        this.command = command;
    }

    public char getCommand() {
        return command;
    }

    public static boolean areValidCommands(String commands){

        for (char command : commands.toCharArray()) {

            boolean isValid = Stream.of(values()).anyMatch(c -> c.getCommand() == (command));

            if (!isValid)
                return false;
        }

        return true;
    }
}
