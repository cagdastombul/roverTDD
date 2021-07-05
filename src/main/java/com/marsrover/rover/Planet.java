package com.marsrover.rover;

import java.util.ArrayList;
import java.util.List;

public class Planet {

    private List<Obstacle> obstacleList;

    public Planet() {
        obstacleList = new ArrayList<>();
    }

    public List<Obstacle> getObstacleList() {
        return obstacleList;
    }

    public void setObstacleList(List<Obstacle> obstacleList) {
        this.obstacleList = obstacleList;
    }
}
