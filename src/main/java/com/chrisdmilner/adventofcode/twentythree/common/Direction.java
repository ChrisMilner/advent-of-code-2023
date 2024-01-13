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

    public static Direction fromUDLRChar(char c) {
        return switch (c) {
            case 'U' -> NORTH;
            case 'D' -> SOUTH;
            case 'L' -> WEST;
            case 'R' -> EAST;
            default -> throw new RuntimeException("Unrecognised direction char: " + c);
        };
    }
}
