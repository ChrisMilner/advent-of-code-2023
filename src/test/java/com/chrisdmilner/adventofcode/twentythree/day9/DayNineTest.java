package com.chrisdmilner.adventofcode.twentythree.day9;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayNineTest {
    private static final PuzzleSolution partOne = new DayNinePartOne();
    private static final PuzzleSolution partTwo = new DayNinePartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(9);

    @Test
    void partOneTest() throws IOException {
        assertEquals(1684566095, partOne.solution(input));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(1136, partTwo.solution(input));
    }
}