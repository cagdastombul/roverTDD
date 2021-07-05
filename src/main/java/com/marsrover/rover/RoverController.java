package com.marsrover.rover;

import org.springframework.web.bind.annotation.*;

@RestController
public class RoverController {

    @PostMapping("/move-rover")
    public String moveRover(@RequestBody MoveRoverApiRequest moveRoverApiRequest) {

        return null;
    }
}
