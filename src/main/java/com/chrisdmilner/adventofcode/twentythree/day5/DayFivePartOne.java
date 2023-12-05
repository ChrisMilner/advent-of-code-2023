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
}
