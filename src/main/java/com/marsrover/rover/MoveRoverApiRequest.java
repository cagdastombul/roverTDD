package com.marsrover.rover;

public class MoveRoverApiRequest {

    private Coordinate initialCoordinate;
    private String initialDirection;
    private String commands;
    private Planet planet;

    public Coordinate getInitialCoordinate() {
        return initialCoordinate;
    }

    public void setInitialCoordinate(Coordinate initialCoordinate) {
        this.initialCoordinate = initialCoordinate;
    }

    public String getInitialDirection() {
        return initialDirection;
    }

    public void setInitialDirection(String initialDirection) {
        this.initialDirection = initialDirection;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}
