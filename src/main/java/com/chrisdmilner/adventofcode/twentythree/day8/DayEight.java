package com.chrisdmilner.adventofcode.twentythree.day8;

import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;

import java.io.IOException;
import java.util.List;

public abstract class DayEight implements PuzzleSolution {
    abstract int getNumberOfSteps(char[] route, Network network);

    public long solution(PuzzleInput input) throws IOException {
        List<String> lines = input.readLines();

        return getNumberOfSteps(
                lines.getFirst().strip().toCharArray(),
                Network.fromLines(lines.subList(2, lines.size()))
        );
    }
}
