package com.chrisdmilner.adventofcode.twentythree.day11;

import com.chrisdmilner.adventofcode.twentythree.common.Coordinates;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class DayEleven implements PuzzleSolution {
    abstract int getMultiplier();

    @Override
    public long solution(PuzzleInput input) throws IOException {
        return findSumOfDistances(parseGalaxyLocations(input.readLines()));
    }

    private List<Coordinates> parseGalaxyLocations(List<String> lines) {
        List<Coordinates> coordinates = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            List<Character> chars = lines.get(i).chars().mapToObj(c -> (char) c).toList();

            for (int j = 0; j < chars.size(); j++) {
                if (chars.get(j).equals('#')) {
                    coordinates.add(new Coordinates(j, i));
                }
            }
        }

        return coordinates;
    }

    private long findSumOfDistances(List<Coordinates> galaxyCoordinates) {
        List<Coordinates> adjustedCoordinates = adjustCoordinates(galaxyCoordinates, getMultiplier());

        long totalDistance = 0;

        for (int i = 0; i < adjustedCoordinates.size(); i++) {
            for (int j = i + 1; j < adjustedCoordinates.size(); j++) {
                totalDistance += manhattanDistance(adjustedCoordinates.get(i), adjustedCoordinates.get(j));
            }
        }

        return totalDistance;
    }

    private List<Coordinates> adjustCoordinates(List<Coordinates> coordinates, int multiplier) {
        Set<Integer> colsWithoutGalaxies = getMissingValues(coordinates.stream().map(Coordinates::x));
        Set<Integer> rowsWithoutGalaxies = getMissingValues(coordinates.stream().map(Coordinates::y));

        return coordinates.stream()
                .map(c -> c.move(
                        (int) colsWithoutGalaxies.stream().filter(i -> i < c.x()).count() * (multiplier - 1),
                        (int) rowsWithoutGalaxies.stream().filter(i -> i < c.y()).count() * (multiplier - 1)
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

    private int manhattanDistance(Coordinates a, Coordinates b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}
