package com.chrisdmilner.adventofcode.twentythree.day14;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

public abstract class DayFourteen implements PuzzleSolution {
    abstract long getLoad(List<List<Rock>> rockCols);

    @Override
    public long solution(PuzzleInput input) throws IOException {
        List<String> lines = input.readLines();

        // TODO: Use input.parseCharGrid instead
        List<List<Rock>> rockColumns = IntStream.range(0, lines.size())
                .mapToObj(i -> lines.stream()
                        .map(l -> l.toCharArray()[i])
                        .map(Rock::fromChar)
                        .toList())
                .toList();

        return getLoad(rockColumns);
    }
}
