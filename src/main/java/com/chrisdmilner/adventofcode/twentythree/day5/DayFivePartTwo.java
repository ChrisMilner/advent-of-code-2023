package com.chrisdmilner.adventofcode.twentythree.day5;

import java.util.List;

public class DayFivePartTwo extends DayFive {
    @Override
    long getSolution(List<Long> seeds, List<RangeMap> maps) {
        long minResult = Long.MAX_VALUE;

        for (int i = 0; i < seeds.size(); i += 2) {
            long start = seeds.get(i);
            long range = seeds.get(i+1);

            for (long j = start; j < start + range; j++) {
                System.out.println("Processing seed: " + j);

                long result = applyMapsSequentially(maps, j);
                if (result < minResult) {
                    minResult = result;
                }
            }
        }

        return minResult;
    }
}
