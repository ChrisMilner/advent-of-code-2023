package com.chrisdmilner.adventofcode.twentythree.day21;

import com.chrisdmilner.adventofcode.twentythree.common.Coordinates;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;

import java.io.IOException;
import java.util.List;

public abstract class DayTwentyOne implements PuzzleSolution {
    abstract long getReachablePlots(List<List<Plot>> plotMap, Coordinates startCoordinates);

    @Override
    public long solution(PuzzleInput input) throws IOException {
        List<List<Plot>> plotMap = input.parseCharGrid(i -> Plot.fromChar((char) i));

        return getReachablePlots(plotMap, findStartCoordinates(plotMap));
    }

    private Coordinates findStartCoordinates(List<List<Plot>> plotMap) {
        for (int y = 0; y < plotMap.size(); y++) {
            List<Plot> row = plotMap.get(y);
            for (int x = 0; x < row.size(); x++) {
                if (plotMap.get(y).get(x).equals(Plot.START)) {
                    return Coordinates.of(x, y);
                }
            }
        }

        throw new RuntimeException("Unable to find start position");
    }

    public enum Plot {
        START, EMPTY, ROCK;

        public static Plot fromChar(char c) {
            return switch (c) {
                case 'S' -> START;
                case '.' -> EMPTY;
                case '#' -> ROCK;
                default -> throw new RuntimeException("Unrecognised plot character: " + c);
            };
        }
    }
}
