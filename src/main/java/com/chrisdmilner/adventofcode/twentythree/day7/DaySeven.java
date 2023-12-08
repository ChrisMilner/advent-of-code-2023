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

    static HandType getHandTypeFromCardFrequency(Map<Character, Integer> cardFrequency) {
        if (cardFrequency.size() == 1) {
            return HandType.FIVE_OF_A_KIND;
        }

        if (cardFrequency.size() == 5) {
            return HandType.HIGH_CARD;
        }

        if (cardFrequency.size() == 2) {
            if (cardFrequency.values().stream().anyMatch(i -> i == 4)) {
                return HandType.FOUR_OF_A_KIND;
            }

            return HandType.FULL_HOUSE;
        }

        if (cardFrequency.values().stream().anyMatch(i -> i == 3)) {
            return HandType.THREE_OF_A_KIND;
        }

        if (cardFrequency.values().stream().filter(i -> i == 2).count() == 2) {
            return HandType.TWO_PAIR;
        }

        return HandType.ONE_PAIR;
    }

    record Hand(String hand, int bid) {
        static Hand fromString(String string) {
            String[] parts = string.split(" ");

            return new Hand(parts[0], Integer.parseInt(parts[1]));
        }
    }
}
