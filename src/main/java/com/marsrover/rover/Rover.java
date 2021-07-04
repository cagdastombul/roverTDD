package com.marsrover.rover;

public class Rover {

    private Coordinate coordinate;
    private Direction direction;

    public Rover(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void moveWithCommands(String commands){

        for (char command : commands.toCharArray()) {

            command = Character.toUpperCase(command);

            if (command == Command.FORWARD.getCommand())
                move(direction);
        }
    }

    private void move(Direction direction) {

        switch (direction) {
            case NORTH:
                coordinate.increaseYByOne();
                break;
            case EAST:
                coordinate.increaseXByOne();
                break;
            case SOUTH:
                coordinate.decreaseYByOne();
                break;
            case WEST:
                coordinate.decreaseXByOne();
                break;
        }
    }
}
