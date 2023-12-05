package com.chrisdmilner.adventofcode.twentythree.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DayFivePartTwo extends DayFive {
    @Override
    long getSolution(List<Long> seeds, List<RangeMap> maps) {
        List<Range> seedRanges = new ArrayList<>();

        for (int i = 0; i< seeds.size(); i += 2) {
            seedRanges.add(new Range(seeds.get(i), seeds.get(i + 1)));
        }

        List<Long> significantSeeds = new ArrayList<>();

        for (int i = 0; i < maps.size(); i++) {
            List<Long> startPoints = maps.get(i).getStartPoints();

            // Backtrack
            for (long startPoint : startPoints) {
                long currVal = startPoint;
                for (int j = i - 1; j >= 0; j--) {
                    currVal = maps.get(j).reverse(currVal);
                }

                significantSeeds.add(currVal);
            }
        }

        List<Long> filteredSeeds = Stream.concat(
                significantSeeds.stream()
                        .filter(seed -> seedRanges.stream().anyMatch(range -> range.contains(seed))),
                seedRanges.stream().map(Range::start)
        ).toList();

        System.out.println(filteredSeeds);

        // Test seeds
        long minResult = Long.MAX_VALUE;

        for (long filteredSeed : filteredSeeds) {
            long result = applyMapsSequentially(maps, filteredSeed);

            if (result < minResult) {
                minResult = result;
            }
        }

        return minResult;
    }

    record Range(long start, long length) {
        public boolean contains(long input) {
            return input >= start && input < (start + length);
        }
    }
}
