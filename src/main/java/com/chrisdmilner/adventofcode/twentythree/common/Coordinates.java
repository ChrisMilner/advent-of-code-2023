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

    public List<Coordinates> getNeighbours() {
        return List.of(move(1, 0), move(0, 1), move( -1, 0), move(0, -1));
    }

    public List<Coordinates> getNeighboursIncludingDiagonal() {
        return List.of(
                move(-1, -1), move(0, -1), move(1, -1),
                move(-1,  0),              move(1,  0),
                move(-1,  1), move(0,  1), move(1,  1)
        );
    }

    public Direction directionTo(Coordinates other) {
        int xDiff = other.x() - this.x();
        int yDiff = other.y() - this.y();

        if (xDiff != 0 && yDiff != 0) {
            throw new RuntimeException("Coordinates differ in multiple dimensions");
        }

        if (xDiff != 0) {
            return xDiff > 0 ? Direction.EAST : Direction.WEST;
        }

        if (yDiff != 0) {
            return yDiff > 0 ? Direction.SOUTH : Direction.NORTH;
        }

        throw new RuntimeException("Coordinate ares the same");
    }

    public static boolean isWithinBounds(Coordinates coordinates, Coordinates dimensions) {
        boolean xInBounds = coordinates.x() >= 0 && coordinates.x() < dimensions.x();
        boolean yInBounds = coordinates.y() >= 0 && coordinates.y() < dimensions.y();

        return xInBounds && yInBounds;
    }

    public static int manhattanDistance(Coordinates a, Coordinates b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}
