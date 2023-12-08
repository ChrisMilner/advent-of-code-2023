package com.chrisdmilner.adventofcode.twentythree.day1;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;

import java.io.IOException;

public abstract class DayOne implements PuzzleSolution {
    abstract int[] getDigits(String line);

    public long solution(PuzzleInput input) throws IOException {
        return input.streamLines()
                .map(this::getDigits)
                .mapToInt(DayOne::combineFirstAndLast)
                .sum();
    }

    static int combineFirstAndLast(int[] digits) {
        return Integer.parseInt(String.valueOf(digits[0]) + digits[digits.length - 1]);
    }
}
