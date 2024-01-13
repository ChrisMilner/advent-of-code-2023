package com.chrisdmilner.adventofcode.twentythree.common;

import java.util.List;

public record Coordinates(int x, int y) {
    public static Coordinates of(int x, int y) {
        return new Coordinates(x, y);
    }

    public Coordinates move(Direction direction, int distance) {
        return switch (direction) {
            case NORTH -> move(0, -distance);
            case EAST -> move(distance, 0);
            case SOUTH -> move(0, distance);
            case WEST -> move(-distance, 0);
        };
    }

    public Coordinates move(Direction direction) {
        return move(direction, 1);
    }

    public Coordinates move(int xDelta, int yDelta) {
        return new Coordinates(x + xDelta, y + yDelta);
    }

    public List<Coordinates> getNeighboursIncludingDiagonal() {
        return List.of(
                move(-1, -1), move(0, -1), move(1, -1),
                move(-1,  0),              move(1,  0),
                move(-1,  1), move(0,  1), move(1,  1)
        );
    }

    public static boolean isWithinBounds(Coordinates coordinates, Coordinates dimensions) {
        boolean xInBounds = coordinates.x() >= 0 && coordinates.x() < dimensions.x();
        boolean yInBounds = coordinates.y() >= 0 && coordinates.y() < dimensions.y();

        return xInBounds && yInBounds;
    }
}
