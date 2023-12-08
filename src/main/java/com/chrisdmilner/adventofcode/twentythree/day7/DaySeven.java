package com.chrisdmilner.adventofcode.twentythree.day7;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    static Map<Character, Integer> stringToCharFrequency(String string) {
        Map<Character, Integer> charFrequency = new HashMap<>();

        for (char c : string.toCharArray()) {
            if (charFrequency.containsKey(c)) {
                charFrequency.put(c, charFrequency.get(c) + 1);
            } else {
                charFrequency.put(c, 1);
            }
        }

        return charFrequency;
    }

    record Hand(String hand, int bid) {
        static Hand fromString(String string) {
            String[] parts = string.split(" ");

            return new Hand(parts[0], Integer.parseInt(parts[1]));
        }
    }
}
