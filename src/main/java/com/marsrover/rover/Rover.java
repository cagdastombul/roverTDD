package com.marsrover.rover;

import java.util.stream.Stream;

public class Rover {

    private Coordinate coordinate;
    private Direction direction;
    private boolean isCollided;

    public Rover(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
        isCollided = false;
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

    public void moveWithCommands(String commands, Planet planet){

        for (char command : commands.toCharArray()) {

            command = Character.toUpperCase(command);

            if (command == Command.FORWARD.getCommand())
                move(direction, planet);

            else if (command == Command.BACKWARD.getCommand())
                move(direction.getBackwardDirection(), planet);

            else if (command == Command.LEFT.getCommand() || command == Command.RIGHT.getCommand())
                changeDirection(command);

            if (isCollided)
                break;
        }
    }

    private void move(Direction direction, Planet planet) {

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

        if (isCollided(planet)){
            move(direction.getBackwardDirection(), planet);
            isCollided = true;
        }
    }

    private boolean isCollided(Planet planet){

        for (Obstacle obstacle : planet.getObstacleList()){

            boolean isCollided = Stream.of(obstacle).anyMatch(o -> o.getCoordinate().getX() == coordinate.getX()
                                                                && o.getCoordinate().getY() == coordinate.getY());

            if(isCollided)
                return true;
        }

        return false;
    }

    private void changeDirection(char command) {

        if (command == Command.LEFT.getCommand())
            direction = Direction.values()[(4 + direction.getDirectionId() - 1) % 4];

        else if (command == Command.RIGHT.getCommand())
            direction = Direction.values()[(4 + direction.getDirectionId() + 1) % 4];
    }

    public String getCurrentCoordinateAndDirection(){

        if (isCollided)
            return "(" + coordinate.getX() + ", " + coordinate.getY() + ") " + direction + " STOPPED";
        else
            return "(" + coordinate.getX() + ", " + coordinate.getY() + ") " + direction;
    }
}
