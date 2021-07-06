package com.marsrover.rover;

public class Obstacle {

    private Coordinate coordinate;

    public Obstacle(){
    }

    public Obstacle(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
