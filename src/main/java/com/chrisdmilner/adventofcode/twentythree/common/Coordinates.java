package com.chrisdmilner.adventofcode.twentythree.common;

import com.chrisdmilner.adventofcode.twentythree.day10.Direction;

public record Coordinates(int x, int y) {
    public Coordinates move(Direction direction) {
        return switch (direction) {
            case NORTH -> move(0, -1);
            case EAST -> move(1, 0);
            case SOUTH -> move(0, 1);
            case WEST -> move(-1, 0);
        };
    }

    public Coordinates move(int xDelta, int yDelta) {
        return new Coordinates(x + xDelta, y + yDelta);
    }
}
