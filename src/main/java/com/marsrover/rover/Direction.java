package com.marsrover.rover;

public enum Direction {

    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private final int directionId;

    Direction(int directionId) {
        this.directionId = directionId;
    }

    public Direction getBackwardDirection() {
        return values()[(this.getDirectionId() + 2) % 4];
    }

    public int getDirectionId() {
        return directionId;
    }

    public static boolean isValidDirection(String direction){

        try {
            Direction.valueOf(direction);
            return true;

        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}