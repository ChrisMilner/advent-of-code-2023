package com.chrisdmilner.adventofcode.twentythree.day10;

public record Coordinates(int x, int y) {
    public Coordinates move(Direction direction) {
        return switch (direction) {
            case NORTH -> new Coordinates(x, y - 1);
            case EAST -> new Coordinates(x + 1, y);
            case SOUTH -> new Coordinates(x, y + 1);
            case WEST -> new Coordinates(x - 1, y);
        };
    }
}
