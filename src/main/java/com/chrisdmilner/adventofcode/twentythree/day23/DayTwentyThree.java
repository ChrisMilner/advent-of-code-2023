package com.chrisdmilner.adventofcode.twentythree.day23;

import com.chrisdmilner.adventofcode.twentythree.common.Coordinates;
import com.chrisdmilner.adventofcode.twentythree.common.Direction;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;

import java.io.IOException;
import java.util.List;

public abstract class DayTwentyThree implements PuzzleSolution {
    abstract long findLongestWalk(List<List<Trail>> map, Coordinates start);

    @Override
    public long solution(PuzzleInput input) throws IOException {
        List<List<Trail>> map = input.parseCharGrid(i -> Trail.fromChar((char) i));
        Coordinates start = findStartPoint(map);

        return findLongestWalk(map, start);
    }

    private Coordinates findStartPoint(List<List<Trail>> map) {
        for (int x = 0; x < map.getFirst().size(); x++) {
            if (map.getFirst().get(x).equals(Trail.PATH)) {
                return Coordinates.of (x, 0);
            }
        }

        throw new RuntimeException("Unable to find start point: " + map.getFirst());
    }

    public enum Trail {
        PATH, LEFT_SLOPE, UP_SLOPE, RIGHT_SLOPE, DOWN_SLOPE, FOREST;

        private static final List<Trail> SLOPES = List.of(LEFT_SLOPE, UP_SLOPE, RIGHT_SLOPE, DOWN_SLOPE);

        public static Trail fromChar(char c) {
            return switch (c) {
                case '.' -> PATH;
                case '>' -> RIGHT_SLOPE;
                case '<' -> LEFT_SLOPE;
                case '^' -> UP_SLOPE;
                case 'v' -> DOWN_SLOPE;
                case '#' -> FOREST;
                default -> throw new RuntimeException("Unrecognised Trail char: " + c);
            };
        }

        public boolean isSlope() {
            return SLOPES.contains(this);
        }

        public Direction getSlopeDirection() {
            return switch (this) {
                case UP_SLOPE -> Direction.NORTH;
                case LEFT_SLOPE -> Direction.WEST;
                case DOWN_SLOPE -> Direction.SOUTH;
                case RIGHT_SLOPE -> Direction.EAST;
                default -> throw new UnsupportedOperationException(this + " has no slope");
            };
        }
    }
}
