package com.chrisdmilner.adventofcode.twentythree.day21;

import com.chrisdmilner.adventofcode.twentythree.common.Coordinates;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DayTwentyOnePartOne extends DayTwentyOne {
    private static final int MAX_MOVES = 64;

    @Override
    long getReachablePlots(List<List<Plot>> plotMap, Coordinates startCoordinates) {
        Set<Coordinates> possibleLocations = findAllReachablePlots(plotMap, startCoordinates);

        return possibleLocations.stream()
                .filter(c -> Coordinates.manhattanDistance(startCoordinates, c) % 2 == 0)
                .count();
    }

    private Set<Coordinates> findAllReachablePlots(List<List<Plot>> plotMap, Coordinates start) {
        Coordinates bounds = Coordinates.of(plotMap.getFirst().size(), plotMap.size());

        Set<Coordinates> frontier = Set.of(start);
        Set<Coordinates> reachableCoordinates = new HashSet<>(frontier);

        for (int step = 0; step < MAX_MOVES; step++) {
            frontier = frontier.stream()
                    .flatMap(c -> c.getNeighbours().stream())
                    .filter(c -> Coordinates.isWithinBounds(c, bounds))
                    .filter(c -> plotMap.get(c.y()).get(c.x()).equals(Plot.EMPTY))
                    .filter(c -> !reachableCoordinates.contains(c))
                    .collect(Collectors.toSet());

            reachableCoordinates.addAll(frontier);
        }

        return reachableCoordinates;
    }

}
