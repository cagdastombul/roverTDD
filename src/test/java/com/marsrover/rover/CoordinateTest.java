package com.marsrover.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CoordinateTest {

    Coordinate coordinate;

    @BeforeEach
    void initializeCoordinate() {
        coordinate = new Coordinate(4, 2);
    }

    @Test
    void increaseXByOneShouldAddOneToX() {

        int initialX = coordinate.getX();

        coordinate.increaseXByOne();

        assertEquals(initialX + 1, coordinate.getX());
    }
}
