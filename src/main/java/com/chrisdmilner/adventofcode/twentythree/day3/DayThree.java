package com.chrisdmilner.adventofcode.twentythree.day3;

import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;

import java.io.IOException;
import java.util.Set;

public abstract class DayThree implements PuzzleSolution {
    private static final Set<Character> NUMBERS = Set.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
    private static final Set<Character> NOT_SYMBOL = Set.of('.', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    abstract int getSolution(char[][] lines);

    public long solution(PuzzleInput input) throws IOException {
        return getSolution(
                input.streamLines()
                        .map(s -> s.strip().toCharArray())
                        .toList()
                        .toArray(new char[0][0])
        );
    }

    static boolean isNumber(char c) {
        return NUMBERS.contains(c);
    }

    static boolean isSymbol(char c) {
        return !NOT_SYMBOL.contains(c);
    }
}
