package com.chrisdmilner.adventofcode.twentythree.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DayOnePartTwo extends DayOne {
    private static final Map<String, Integer> NUMBER_MAP = Map.of(
            "one",      1,
            "two",      2,
            "three",    3,
            "four",     4,
            "five",     5,
            "six",      6,
            "seven",    7,
            "eight",    8,
            "nine",     9
    );

    int[] getDigits(String string) {
        List<Integer> digits = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.toCharArray()[i])) {
                digits.add(Character.getNumericValue(string.toCharArray()[i]));
                continue;
            }

            getSpeltOutDigit(string.substring(i)).ifPresent(digits::add);
        }

        return digits.stream().mapToInt(i -> i).toArray();
    }

    private static Optional<Integer> getSpeltOutDigit(String string) {
        return NUMBER_MAP.keySet().stream()
                .filter(string::startsWith)
                .map(NUMBER_MAP::get)
                .findFirst();
    }
}
