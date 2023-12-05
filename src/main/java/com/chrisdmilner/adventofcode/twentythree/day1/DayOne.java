package com.chrisdmilner.adventofcode.twentythree.day1;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;

import java.io.IOException;

public abstract class DayOne {
    abstract int[] getDigits(String line);

    public int solution(PuzzleInput input) throws IOException {
        return input.streamLines()
                .map(this::getDigits)
                .mapToInt(DayOne::combineFirstAndLast)
                .sum();
    }

    static int combineFirstAndLast(int[] digits) {
        return Integer.parseInt(String.valueOf(digits[0]) + digits[digits.length - 1]);
    }
}
