package com.chrisdmilner.adventofcode.twentythree.day10;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;

import java.io.IOException;

public abstract class DayTen implements PuzzleSolution {
    abstract int getStepsToFarthestPoint(PipeNetwork pipes);

    @Override
    public long solution(PuzzleInput input) throws IOException {
        return getStepsToFarthestPoint(PipeNetwork.fromStrings(input.readLines()));
    }
}
