package com.chrisdmilner.adventofcode.twentythree.day20;

import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;

import java.io.IOException;
import java.util.List;

public abstract class DayTwenty implements PuzzleSolution {
    abstract long getSolution(List<String> lines);

    @Override
    public long solution(PuzzleInput input) throws IOException {
        return getSolution(input.readLines());
    }
}
