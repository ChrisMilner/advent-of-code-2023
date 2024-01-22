package com.chrisdmilner.adventofcode.twentythree.day21;

import com.chrisdmilner.adventofcode.twentythree.common.Coordinates;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DayTwentyOnePartTwo extends DayTwentyOne {
    private static final int MAX_MOVES = 26501365;

    @Override
    long getReachablePlots(List<List<Plot>> plotMap, Coordinates startCoordinates) {
        Set<Coordinates> possibleLocations = findAllReachablePlots(plotMap, startCoordinates);

        return possibleLocations.stream()
                .filter(c -> Coordinates.manhattanDistance(startCoordinates, c) % 2 == 1)
                .count();
    }

    private Set<Coordinates> findAllReachablePlots(List<List<Plot>> plotMap, Coordinates start) {
        Set<Coordinates> frontier = Set.of(start);
        Set<Coordinates> reachableCoordinates = new HashSet<>(frontier);

        for (int step = 0; step < MAX_MOVES; step++) {
            System.out.println(step);
            System.out.println(frontier.size());
            System.out.println();

            frontier = frontier.stream()
                    .flatMap(c -> c.getNeighbours().stream())
                    .filter(c -> getPlot(plotMap, c).equals(Plot.EMPTY))
                    .filter(c -> !reachableCoordinates.contains(c))
                    .collect(Collectors.toSet());

            reachableCoordinates.addAll(frontier);
        }

        return reachableCoordinates;
    }

    private static Plot getPlot(List<List<Plot>> plotMap, Coordinates c) {
        return plotMap.get(Math.floorMod(c.y(), plotMap.size()))
                .get(Math.floorMod(c.x(), plotMap.getFirst().size()));
    }

}
