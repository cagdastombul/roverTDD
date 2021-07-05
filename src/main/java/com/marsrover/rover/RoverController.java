package com.marsrover.rover;

import org.springframework.web.bind.annotation.*;

@RestController
public class RoverController {

    @PostMapping("/move-rover")
    public String moveRover(@RequestBody MoveRoverApiRequest moveRoverApiRequest) {

        if (!Direction.isValidDirection(moveRoverApiRequest.getInitialDirection()))
            return ErrorMessageConstants.INVALID_DIRECTION;

        if (!Command.areValidCommands(moveRoverApiRequest.getCommands()))
            return ErrorMessageConstants.INVALID_COMMAND;

        return null;
    }
}
