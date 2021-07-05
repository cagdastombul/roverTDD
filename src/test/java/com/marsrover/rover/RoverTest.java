package com.marsrover.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RoverTest {

    private static Rover rover = new Rover(new Coordinate(4, 2), Direction.NORTH);

    @BeforeEach
    void initializeRover() {
        rover = new Rover(new Coordinate(4, 2), Direction.NORTH);
    }

    @ParameterizedTest
    @MethodSource("provideDirectionAndExpectedCoordinateForMoveForwardAndBackward")
    void moveWithCommandsShouldMoveRoverWhenCommandIsFOrB(Command command, Direction direction, Coordinate expectedCoordinate) {

        rover.setDirection(direction);
        rover.moveWithCommands(String.valueOf(command.getCommand()), new Planet());

        assertEquals(direction, rover.getDirection());
        assertEquals(expectedCoordinate.getX(), rover.getCoordinate().getX());
        assertEquals(expectedCoordinate.getY(), rover.getCoordinate().getY());
    }

    private static Stream<Arguments> provideDirectionAndExpectedCoordinateForMoveForwardAndBackward(){

        return Stream.of(
                Arguments.of(Command.FORWARD, Direction.NORTH, new Coordinate(rover.getCoordinate().getX(), rover.getCoordinate().getY() + 1)),
                Arguments.of(Command.FORWARD, Direction.EAST, new Coordinate(rover.getCoordinate().getX() + 1, rover.getCoordinate().getY())),
                Arguments.of(Command.FORWARD, Direction.SOUTH, new Coordinate(rover.getCoordinate().getX(), rover.getCoordinate().getY() - 1)),
                Arguments.of(Command.FORWARD, Direction.WEST, new Coordinate(rover.getCoordinate().getX() - 1, rover.getCoordinate().getY())),
                Arguments.of(Command.BACKWARD, Direction.NORTH, new Coordinate(rover.getCoordinate().getX(), rover.getCoordinate().getY() - 1)),
                Arguments.of(Command.BACKWARD, Direction.EAST, new Coordinate(rover.getCoordinate().getX() - 1, rover.getCoordinate().getY())),
                Arguments.of(Command.BACKWARD, Direction.SOUTH, new Coordinate(rover.getCoordinate().getX(), rover.getCoordinate().getY() + 1)),
                Arguments.of(Command.BACKWARD, Direction.WEST, new Coordinate(rover.getCoordinate().getX() + 1, rover.getCoordinate().getY())));
    }

    @ParameterizedTest
    @MethodSource("provideRoverAndExpectedDirectionForTurnLeftAndRight")
    void moveWithCommandsShouldTurnWhenCommandIsLOrR(Command command, Direction roverDirection, Direction expectedDirectionAfterTurn) {

        rover.setDirection(roverDirection);
        rover.moveWithCommands(String.valueOf(command.getCommand()), new Planet());

        assertEquals(expectedDirectionAfterTurn, rover.getDirection());
    }

    private static Stream<Arguments> provideRoverAndExpectedDirectionForTurnLeftAndRight(){

        return Stream.of(
                Arguments.of(Command.LEFT, Direction.NORTH, Direction.WEST),
                Arguments.of(Command.LEFT, Direction.EAST, Direction.NORTH),
                Arguments.of(Command.LEFT, Direction.SOUTH, Direction.EAST),
                Arguments.of(Command.LEFT, Direction.WEST, Direction.SOUTH),
                Arguments.of(Command.RIGHT, Direction.NORTH, Direction.EAST),
                Arguments.of(Command.RIGHT, Direction.EAST, Direction.SOUTH),
                Arguments.of(Command.RIGHT, Direction.SOUTH, Direction.WEST),
                Arguments.of(Command.RIGHT, Direction.WEST, Direction.NORTH));
    }

    @Test
    void moveWithCommandsShouldReportCurrentLocationBeforeAnObstacle(){

        List<Obstacle> obstacleList = Collections.singletonList(new Obstacle(new Coordinate(2, 3)));

        Planet planet = new Planet();
        planet.setObstacleList(obstacleList);

        rover.moveWithCommands("FLFFFRFLB", planet);

        assertEquals("(3, 3) WEST STOPPED", rover.getCurrentCoordinateAndDirection());
    }

    @Test
    void getCurrentCoordinateAndDirectionShouldReturnRoversCoordinateAndDirection(){

        assertEquals("(4, 2) NORTH", rover.getCurrentCoordinateAndDirection());
    }
}
