package com.marsrover.rover;

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
}
