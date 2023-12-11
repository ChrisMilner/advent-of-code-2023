package com.chrisdmilner.adventofcode.twentythree.day10;

import java.util.Arrays;
import java.util.List;

import static com.chrisdmilner.adventofcode.twentythree.day10.Direction.*;

public enum Pipe {
    NORTH_SOUTH('|', List.of(NORTH, SOUTH)),
    EAST_WEST('-', List.of(EAST, WEST)),
    NORTH_EAST('L', List.of(NORTH, EAST)),
    NORTH_WEST('J', List.of(NORTH, WEST)),
    SOUTH_WEST('7', List.of(SOUTH, WEST)),
    SOUTH_EAST('F', List.of(SOUTH, EAST)),
    GROUD('.', List.of()),
    START('S', List.of(NORTH, EAST, SOUTH, WEST));

    private final char charRepresentation;
    private final List<Direction> directions;

    Pipe(char charRepresentation, List<Direction> directions) {
        this.charRepresentation = charRepresentation;
        this.directions = directions;
    }

    static Pipe fromChar(char character) {
        return Arrays.stream(Pipe.values())
                .filter(e -> e.charRepresentation == character)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No pipe type found for char"));
    }

    public List<Direction> getPossibleDirections() {
        return directions;
    }
}
