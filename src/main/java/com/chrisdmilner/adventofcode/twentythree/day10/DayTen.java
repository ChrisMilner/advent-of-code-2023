package com.chrisdmilner.adventofcode.twentythree.day10;

import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;

import java.io.IOException;
import java.util.List;

public abstract class DayTen implements PuzzleSolution {
    abstract int getStepsToFarthestPoint(PipeNetwork pipes);

    @Override
    public long solution(PuzzleInput input) throws IOException {
        List<List<Pipe>> pipes = input.parseCharGrid(c -> Pipe.fromChar((char) c));

        return getStepsToFarthestPoint(PipeNetwork.fromPipeGrid(pipes));
    }
}
