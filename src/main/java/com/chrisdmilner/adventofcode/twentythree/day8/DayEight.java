package com.chrisdmilner.adventofcode.twentythree.day8;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;

import java.io.IOException;
import java.util.List;

public abstract class DayEight {
    abstract int getNumberOfSteps(char[] route, Network network);

    int solution(PuzzleInput input) throws IOException {
        List<String> lines = input.readLines();

        return getNumberOfSteps(
                lines.get(0).strip().toCharArray(),
                Network.fromLines(lines.subList(2, lines.size()))
        );
    }
}
