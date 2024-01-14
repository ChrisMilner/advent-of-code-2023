package com.chrisdmilner.adventofcode.twentythree.day5;

import com.chrisdmilner.adventofcode.twentythree.common.utils.ListUtils;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public abstract class DayFive implements PuzzleSolution {
    abstract long getSolution(List<Long> seeds, List<RangeMap> maps);

    public long solution(PuzzleInput input) throws IOException {
        List<String> lines = input.readLines();

        return getSolution(parseSeeds(lines.getFirst()), parseMaps(lines.subList(2, lines.size())));
    }

    private List<Long> parseSeeds(String line) {
        String numbers = line.split(": ")[1];

        return Arrays.stream(numbers.split(" "))
                .map(Long::parseLong)
                .toList();
    }

    private List<RangeMap> parseMaps(List<String> lines) {
        return ListUtils.splitList(lines, line -> line.isBlank() || line.endsWith("map:")).stream()
                .map(RangeMap::fromLines)
                .toList();
    }

    static long applyMapsSequentially(List<RangeMap> maps, long seed) {
        long currVal = seed;

        for (RangeMap map : maps) {
            currVal = map.apply(currVal);
        }

        return currVal;
    }
}
