package com.marsrover.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RoverControllerTest {

    @InjectMocks
    RoverController roverController;

    MoveRoverApiRequest moveRoverApiRequest;

    @BeforeEach
    void initializeRover() {
        moveRoverApiRequest = new MoveRoverApiRequest();
        moveRoverApiRequest.setInitialDirection(Direction.EAST.toString());
        moveRoverApiRequest.setInitialCoordinate(new Coordinate(4, 2));
        moveRoverApiRequest.setCommands("FLFFFRFLB");
    }

    @Test
    void moveRoverShouldReturnErrorMessageWhenDirectionIsInvalid() {

        moveRoverApiRequest.setInitialDirection("A");

        String response = roverController.moveRover(moveRoverApiRequest);

        assertEquals(ErrorMessageConstants.INVALID_DIRECTION, response);
    }

    @Test
    void moveRoverShouldReturnErrorMessageWhenACommandIsInvalid() {

        moveRoverApiRequest.setCommands("A");

        String response = roverController.moveRover(moveRoverApiRequest);

        assertEquals(ErrorMessageConstants.INVALID_COMMAND, response);
    }
}
