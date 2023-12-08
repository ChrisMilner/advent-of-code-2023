package com.chrisdmilner.adventofcode.twentythree.day5;

import java.util.ArrayList;
import java.util.List;

public class DayFivePartTwo extends DayFive {
    @Override
    long getSolution(List<Long> seeds, List<RangeMap> maps) {
        List<Range> seedRanges = getSeedRanges(seeds);
        List<Long> significantSeeds = getSignificantSeeds(maps, seedRanges);

        long minResult = Long.MAX_VALUE;

        for (long seed : significantSeeds) {
            long result = applyMapsSequentially(maps, seed);

            if (result < minResult) {
                minResult = result;
            }
        }

        return minResult;
    }

    private static List<Range> getSeedRanges(List<Long> seeds) {
        List<Range> seedRanges = new ArrayList<>();

        for (int i = 0; i< seeds.size(); i += 2) {
            seedRanges.add(new Range(seeds.get(i), seeds.get(i + 1)));
        }

        return seedRanges;
    }

    private static List<Long> getSignificantSeeds(List<RangeMap> maps, List<Range> seedRanges) {
        List<Long> significantSeeds = new ArrayList<>();

        for (int i = 0; i < maps.size(); i++) {
            List<Long> startPoints = maps.get(i).getTransitionPoints();

            // Backtrack the start points through all the previous maps
            for (long startPoint : startPoints) {
                long currVal = startPoint;

                for (int j = i - 1; j >= 0; j--) {
                    currVal = maps.get(j).reverse(currVal);
                }

                long finalCurrVal = currVal;
                if (seedRanges.stream().anyMatch(range -> range.contains(finalCurrVal))) {
                    significantSeeds.add(currVal);
                }
            }
        }

        significantSeeds.addAll(seedRanges.stream().map(Range::start).toList());

        return significantSeeds;
    }

    record Range(long start, long length) {
        public boolean contains(long input) {
            return input >= start && input < (start + length);
        }
    }
}
