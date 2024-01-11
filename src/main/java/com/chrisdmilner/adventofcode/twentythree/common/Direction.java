package com.chrisdmilner.adventofcode.twentythree.common;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public Direction opposite() {
        return switch (this) {
            case NORTH -> SOUTH;
            case EAST -> WEST;
            case SOUTH -> NORTH;
            case WEST -> EAST;
        };
    }
}
