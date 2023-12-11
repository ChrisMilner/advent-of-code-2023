package com.chrisdmilner.adventofcode.twentythree.day10;

import com.chrisdmilner.adventofcode.twentythree.common.Coordinates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.chrisdmilner.adventofcode.twentythree.day10.Pipe.*;

public class DayTenPartTwo extends DayTen {
    @Override
    int getStepsToFarthestPoint(PipeNetwork pipes) {
        List<Coordinates> loop = getLoop(pipes);

        int enclosedTiles = 0;

        for (int x = 0; x < pipes.getWidth(); x++) {
            for (int y = 0; y < pipes.getHeight(); y++) {
                if (countCrossings(x, y, loop, pipes) % 2 == 1) {
                    enclosedTiles++;
                }
            }
        }

        return enclosedTiles;
    }

    private List<Coordinates> getLoop(PipeNetwork pipes) {
        for (Direction direction : pipes.getPossibleMoves()) {
            List<Coordinates> loop = new ArrayList<>();
            loop.add(pipes.getCurrentCoordinates());

            pipes.move(direction);

            Direction prevMove = direction;

            while (!pipes.atStart() && !pipes.getPossibleMoves().isEmpty()) {
                loop.add(pipes.getCurrentCoordinates());

                Direction finalPrevMove = prevMove;
                Direction directionToMove = pipes.getPossibleMoves().stream()
                        .filter(d -> !d.equals(finalPrevMove.opposite()))
                        .findFirst().orElseThrow();

                pipes.move(directionToMove);

                prevMove = directionToMove;
            }

            if (pipes.atStart()) {
                return loop;
            }
        }

        throw new RuntimeException("No loop found");
    }

    private int countCrossings(int x, int y, List<Coordinates> loop, PipeNetwork pipes) {
        Coordinates coordinates = new Coordinates(x, y);

        if (loop.contains(coordinates)) {
            return 0;
        }

        int crossings = 0;

        while (coordinates.y() >= 0) {
            coordinates = coordinates.move(0, -1);

            if (loop.contains(coordinates)) {
                Pipe pipe = inferPipeAtCoords(loop, coordinates, pipes);

                if (pipe.getPossibleDirections().contains(Direction.EAST)) {
                    crossings++;
                }
            }
        }

        return crossings;
    }

    private Pipe inferPipeAtCoords(List<Coordinates> loop, Coordinates coordinates, PipeNetwork pipes) {
        Pipe pipe = pipes.getPipeAtCoordinate(coordinates);

        if (!pipe.equals(START)) {
            return pipe;
        }

        List<Direction> pipeDirections = List.of(
                getDirectionTo(coordinates, loop.get(1)),
                getDirectionTo(coordinates, loop.getLast())
        );

        return Arrays.stream(values())
                .filter(p -> p.getPossibleDirections().containsAll(pipeDirections))
                .findFirst().orElseThrow();
    }

    private Direction getDirectionTo(Coordinates a, Coordinates b) {
        if (a.x() == b.x()) {
            return a.y() > b.y() ? Direction.NORTH : Direction.SOUTH;
        }

        return a.x() > b.x() ? Direction.WEST : Direction.EAST;
    }
}
