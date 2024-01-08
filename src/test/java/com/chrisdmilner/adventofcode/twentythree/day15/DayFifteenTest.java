package com.chrisdmilner.adventofcode.twentythree.day15;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayFifteenTest {
    private static final PuzzleSolution partOne = new DayFifteenPartOne();
    private static final PuzzleSolution partTwo = new DayFifteenPartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(15);
    private static final PuzzleInput exampleInput = PuzzleInputReader.getExampleInputFile(15);

    @Test
    void partOneTest() throws IOException {
        assertEquals(507291, partOne.solution(input));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(296921, partTwo.solution(input));
    }

    @Test
    void partTwoExampleTest() throws IOException {
        assertEquals(145, partTwo.solution(exampleInput));
    }
}