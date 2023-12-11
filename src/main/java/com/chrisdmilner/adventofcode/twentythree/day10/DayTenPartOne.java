package com.chrisdmilner.adventofcode.twentythree.day10;

public class DayTenPartOne extends DayTen {
    @Override
    int getStepsToFarthestPoint(PipeNetwork pipes) {
        for (Direction direction : pipes.getPossibleMoves()) {
            pipes.move(direction);
            int steps = 1;

            Direction prevMove = direction;

            while (!pipes.atStart() && !pipes.getPossibleMoves().isEmpty()) {
                Direction finalPrevMove = prevMove;
                Direction directionToMove = pipes.getPossibleMoves().stream()
                        .filter(d -> !d.equals(finalPrevMove.opposite()))
                        .findFirst().orElseThrow();

                pipes.move(directionToMove);

                prevMove = directionToMove;
                steps++;
            }

            if (pipes.atStart()) {
                return steps / 2;
            }
        }

        throw new RuntimeException("No loop found");
    }
}
