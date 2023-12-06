package com.chrisdmilner.adventofcode.twentythree.day6;

import java.util.List;

public class DaySixPartTwo extends DaySix {
    @Override
    long getSolution(List<Integer> times, List<Integer> distances) {
        long time = combineNumberList(times);
        long distance = combineNumberList(distances);

        return solveQuadratic(-1, time, -distance).streamLongsBetween().count();
    }

    private long combineNumberList(List<Integer> numbers) {
        StringBuilder numberStringBuilder = new StringBuilder();
        numbers.forEach(numberStringBuilder::append);

        return Long.parseLong(numberStringBuilder.toString());
    }
}
