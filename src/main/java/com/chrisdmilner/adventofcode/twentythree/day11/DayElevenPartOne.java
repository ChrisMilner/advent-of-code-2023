package com.chrisdmilner.adventofcode.twentythree.day11;

import com.chrisdmilner.adventofcode.twentythree.common.Coordinates;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DayElevenPartOne extends DayEleven {
    @Override
    long findSumOfDistances(List<Coordinates> galaxyCoordinates) {
        List<Coordinates> adjustedCoordinates = adjustCoordinates(galaxyCoordinates);

        long totalDistance = 0;

        for (int i = 0; i < adjustedCoordinates.size(); i++) {
            for (int j = i + 1; j < adjustedCoordinates.size(); j++) {
                totalDistance += manhattanDistance(adjustedCoordinates.get(i), adjustedCoordinates.get(j));
            }
        }

        return totalDistance;
    }

    private int manhattanDistance(Coordinates a, Coordinates b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }

    private List<Coordinates> adjustCoordinates(List<Coordinates> coordinates) {
        Set<Integer> colsWithoutGalaxies = getMissingValues(coordinates.stream().map(Coordinates::x));
        Set<Integer> rowsWithoutGalaxies = getMissingValues(coordinates.stream().map(Coordinates::y));

        return coordinates.stream()
                .map(c -> c.move(
                        (int) colsWithoutGalaxies.stream().filter(i -> i < c.x()).count(),
                        (int) rowsWithoutGalaxies.stream().filter(i -> i < c.y()).count()
                ))
                .toList();
    }

    private Set<Integer> getMissingValues(Stream<Integer> values) {
        Set<Integer> valueSet = values.collect(Collectors.toSet());
        Integer maxValue = valueSet.stream().max(Integer::compare).orElseThrow();

        return IntStream.range(0, maxValue)
                .filter(i -> !valueSet.contains(i))
                .boxed()
                .collect(Collectors.toSet());
    }
}
