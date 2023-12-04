package com.chrisdmilner.adventofcode.twentythree.day3;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;

import java.io.IOException;

public abstract class DayThree {
    abstract int getSolution(char[][] lines);

    public int solution() throws IOException {
        return getSolution(
                PuzzleInputReader.streamInputLines(3)
                        .map(s -> s.strip().toCharArray())
                        .toList()
                        .toArray(new char[0][0])
        );
    }
}
