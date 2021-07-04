package com.marsrover.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

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
    @MethodSource("provideDirectionAndExpectedCoordinateForMoveForward")
    void moveWithCommandsShouldMoveForwardInRoverDirectionWhenCommandIsF(Direction direction, Coordinate expectedCoordinate) {

        rover.setDirection(direction);
        rover.moveWithCommands(Command.FORWARD.toString());

        assertEquals(direction, rover.getDirection());
        assertEquals(expectedCoordinate.getX(), rover.getCoordinate().getX());
        assertEquals(expectedCoordinate.getY(), rover.getCoordinate().getY());
    }

    private static Stream<Arguments> provideDirectionAndExpectedCoordinateForMoveForward(){

        return Stream.of(
                Arguments.of(Direction.NORTH, new Coordinate(rover.getCoordinate().getX(), rover.getCoordinate().getY() + 1)),
                Arguments.of(Direction.EAST, new Coordinate(rover.getCoordinate().getX() + 1, rover.getCoordinate().getY())),
                Arguments.of(Direction.SOUTH, new Coordinate(rover.getCoordinate().getX(), rover.getCoordinate().getY() - 1)),
                Arguments.of(Direction.WEST, new Coordinate(rover.getCoordinate().getX() - 1, rover.getCoordinate().getY())));
    }
}
