package com.chrisdmilner.adventofcode.twentythree.day23;

import com.chrisdmilner.adventofcode.twentythree.common.Coordinates;
import com.chrisdmilner.adventofcode.twentythree.common.Direction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayTwentyThreePartOne extends DayTwentyThree {
    @Override
    long findLongestWalk(List<List<Trail>> map, Coordinates start) {
        return longestPath(map, start, Direction.NORTH, List.of());
    }

    private long longestPath(
            List<List<Trail>> map,
            Coordinates position,
            Direction arrival,
            List<Coordinates> slopesPast) {
        List<Coordinates> possibleMoves = getPossibleMoves(map, position, arrival, slopesPast);
        List<Coordinates> currentSlopesPast = new ArrayList<>(slopesPast);
        Coordinates currentPosition = position;

        int moves = 0;

        while (possibleMoves.size() == 1) {
            Coordinates newCoordinate = possibleMoves.getFirst();

            if (getTrailAtPos(map, newCoordinate).isSlope()) {
                currentSlopesPast.add(newCoordinate);
            }

            possibleMoves = getPossibleMoves(map, newCoordinate, newCoordinate.directionTo(currentPosition), currentSlopesPast);

            moves++;
            currentPosition = newCoordinate;
        }

        if (possibleMoves.size() > 1) {
            Coordinates finalCurrentPosition = currentPosition;

            // TODO: check if it's a slope and add to list

            return moves + possibleMoves.stream()
                    .mapToLong(m -> 1 + longestPath(map, m, m.directionTo(finalCurrentPosition), currentSlopesPast))
                    .max().orElseThrow();
        }

        return moves;
    }

    private List<Coordinates> getPossibleMoves(
            List<List<Trail>> map,
            Coordinates currentPosition,
            Direction arrival,
            List<Coordinates> slopesPast) {
        return Arrays.stream(Direction.values())
                .filter(d -> filterDirections(d, map, currentPosition, arrival, slopesPast))
                .map(currentPosition::move)
                .toList();
    }

    private static boolean filterDirections(
            Direction direction,
            List<List<Trail>> map,
            Coordinates currentPosition,
            Direction arrival,
            List<Coordinates> slopesPast) {
        Coordinates mapDimensions = Coordinates.of(map.getFirst().size(), map.size());
        Coordinates move = currentPosition.move(direction);

        if (!Coordinates.isWithinBounds(move, mapDimensions)) {
            return false;
        }

        Trail trail = getTrailAtPos(map, move);

        if (trail.equals(Trail.FOREST)) {
            return false;
        }

        if (direction.equals(arrival)) {
            return false;
        }

        if (slopesPast.contains(move)) {
            return false;
        }

        return !trail.isSlope() || trail.getSlopeDirection().equals(direction);
    }

    private static Trail getTrailAtPos(List<List<Trail>> map, Coordinates pos) {
        return map.get(pos.y()).get(pos.x());
    }
}
