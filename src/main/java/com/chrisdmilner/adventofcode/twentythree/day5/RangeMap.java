package com.chrisdmilner.adventofcode.twentythree.day5;

import java.util.List;
import java.util.stream.Stream;

public class RangeMap {
    private final List<RangeMapEntry> entries;

    RangeMap(List<RangeMapEntry> entries) {
        this.entries = entries;
    }

    public static RangeMap fromLines(List<String> lines) {
        return new RangeMap(lines.stream().map(RangeMapEntry::fromLine).toList());
    }

    public long apply(long input) {
        return entries.stream()
                .filter(entry -> entry.appliesTo(input))
                .map(entry -> entry.apply(input))
                .findFirst()
                .orElse(input);
    }

    public long reverse(long input) {
        return entries.stream()
                .filter(entry -> entry.reverseAppliesTo(input))
                .map(entry -> entry.reverse(input))
                .findFirst()
                .orElse(input);
    }

    public List<Long> getTransitionPoints() {
        return entries.stream()
                .flatMap(e -> Stream.of(e.sourceStart(), e.sourceStart() + e.length()))
                .toList();
    }

    record RangeMapEntry(long sourceStart, long destinationStart, long length) {
        static RangeMapEntry fromLine(String line) {
            String[] numbers = line.split(" ");

            return new RangeMapEntry(
                    Long.parseLong(numbers[1]),
                    Long.parseLong(numbers[0]),
                    Long.parseLong(numbers[2])
            );
        }

        public boolean appliesTo(long input) {
            return input >= sourceStart && input < sourceStart + length;
        }

        public boolean reverseAppliesTo(long input) {
            return input >= destinationStart && input < destinationStart + length;
        }

        public long apply(long input) {
            return destinationStart + (input - sourceStart);
        }

        public long reverse(long input) {
            return sourceStart + (input - destinationStart);
        }
    }
}
