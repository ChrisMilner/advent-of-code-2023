package com.chrisdmilner.adventofcode.twentythree.day16;

import com.chrisdmilner.adventofcode.twentythree.common.Direction;

import java.util.List;

import static com.chrisdmilner.adventofcode.twentythree.common.Direction.*;

public enum Reflector {
    EMPTY, FORWARD_MIRROR, BACKWARD_MIRROR, HORIZONTAL_SPLITTER, VERTICAL_SPLITTER;

    public static Reflector fromChar(char c) {
        return switch (c) {
            case '.' -> EMPTY;
            case '/' -> FORWARD_MIRROR;
            case '\\' -> BACKWARD_MIRROR;
            case '-' -> HORIZONTAL_SPLITTER;
            case '|' -> VERTICAL_SPLITTER;
            default -> throw new RuntimeException("Unknown char in input " + c);
        };
    }

    public List<Direction> getResultingDirections(Direction direction) {
        return switch (this) {
            case EMPTY -> List.of(direction);
            case FORWARD_MIRROR -> List.of(forwardMirrorResultingDirections(direction));
            case BACKWARD_MIRROR -> List.of(backwardMirrorResultingDirections(direction));
            case HORIZONTAL_SPLITTER -> horizontalSplitterResultingDirections(direction);
            case VERTICAL_SPLITTER -> verticalSplitterResultingDirections(direction);
        };
    }

    private static Direction forwardMirrorResultingDirections(Direction direction) {
        return switch (direction) {
            case NORTH -> EAST;
            case EAST -> NORTH;
            case SOUTH -> WEST;
            case WEST -> SOUTH;
        };
    }

    private static Direction backwardMirrorResultingDirections(Direction direction) {
        return forwardMirrorResultingDirections(direction).opposite();
    }

    private static List<Direction> horizontalSplitterResultingDirections(Direction direction) {
        return switch (direction) {
            case NORTH, SOUTH -> List.of(EAST, WEST);
            case EAST, WEST -> List.of(direction);
        };
    }

    private static List<Direction> verticalSplitterResultingDirections(Direction direction) {
        return switch (direction) {
            case NORTH, SOUTH -> List.of(direction);
            case EAST, WEST -> List.of(NORTH, SOUTH);
        };
    }
}
