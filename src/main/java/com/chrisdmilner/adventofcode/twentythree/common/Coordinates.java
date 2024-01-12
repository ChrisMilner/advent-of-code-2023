package com.chrisdmilner.adventofcode.twentythree.common;

public record Coordinates(int x, int y) {
    public static Coordinates of(int x, int y) {
        return new Coordinates(x, y);
    }

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

    public static boolean isWithinBounds(Coordinates coordinates, Coordinates dimensions) {
        boolean xInBounds = coordinates.x() >= 0 && coordinates.x() < dimensions.x();
        boolean yInBounds = coordinates.y() >= 0 && coordinates.y() < dimensions.y();

        return xInBounds && yInBounds;
    }
}
