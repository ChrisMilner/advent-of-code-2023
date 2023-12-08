package com.chrisdmilner.adventofcode.twentythree.day5;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DayFive implements PuzzleSolution {
    abstract long getSolution(List<Long> seeds, List<RangeMap> maps);

    public long solution(PuzzleInput input) throws IOException {
        List<String> lines = input.readLines();

        return getSolution(parseSeeds(lines.get(0)), parseMaps(lines.subList(2, lines.size())));
    }

    private List<Long> parseSeeds(String line) {
        String numbers = line.split(": ")[1];

        return Arrays.stream(numbers.split(" "))
                .map(Long::parseLong)
                .toList();
    }

    private List<RangeMap> parseMaps(List<String> lines) {
        List<RangeMap> rangeMaps = new ArrayList<>();
        List<String> lineBuffer = new ArrayList<>();

        for (String line : lines) {
            if (line.isBlank() || line.endsWith("map:")) {
                if (!lineBuffer.isEmpty()) {
                    rangeMaps.add(RangeMap.fromLines(lineBuffer));
                }
                lineBuffer = new ArrayList<>();
            } else {
                lineBuffer.add(line);
            }
        }

        if (!lineBuffer.isEmpty()) {
            rangeMaps.add(RangeMap.fromLines(lineBuffer));
        }

        return rangeMaps;
    }

    static long applyMapsSequentially(List<RangeMap> maps, long seed) {
        long currVal = seed;

        for (RangeMap map : maps) {
            currVal = map.apply(currVal);
        }

        return currVal;
    }
}
