package com.chrisdmilner.adventofcode.twentythree.day7;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.LongStream;

public abstract class DaySeven {
    abstract Comparator<Hand> getComparator();

    public long solution(PuzzleInput input) throws IOException {
        List<Hand> orderedHands = input.streamLines()
                .map(Hand::fromString)
                .sorted(getComparator())
                .toList();

        return LongStream.range(0, orderedHands.size())
                .map(i -> (i + 1) * orderedHands.get((int) i).bid())
                .sum();
    }

    record Hand(String hand, int bid) {
        static Hand fromString(String string) {
            String[] parts = string.split(" ");

            return new Hand(parts[0], Integer.parseInt(parts[1]));
        }
    }
}
