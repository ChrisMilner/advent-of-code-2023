package com.chrisdmilner.adventofcode.twentythree.day5;

import java.util.List;

public class DayFivePartOne extends DayFive {
    @Override
    long getSolution(List<Long> seeds, List<RangeMap> maps) {
        return seeds.stream()
                .mapToLong(seed -> applyMapsSequentially(maps, seed))
                .min()
                .orElse(-1);
    }

    private long applyMapsSequentially(List<RangeMap> maps, long seed) {
        long currVal = seed;

        for (RangeMap map : maps) {
            currVal = map.apply(currVal);
        }

        return currVal;
    }
}
