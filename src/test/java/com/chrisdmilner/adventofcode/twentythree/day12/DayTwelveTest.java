package com.chrisdmilner.adventofcode.twentythree.day12;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayTwelveTest {
    private static final PuzzleSolution partOne = new DayTwelvePartOne();
    private static final PuzzleSolution partTwo = new DayTwelvePartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(12);
    private static final PuzzleInput exampleInput = PuzzleInputReader.getExampleInputFile(12);

    @Test
    void partOneTest() throws IOException {
        assertEquals(7541, partOne.solution(input));
    }

    @Test
    void partOneExampleTest() throws IOException {
        assertEquals(21, partOne.solution(exampleInput));
    }

    @Test
    @Disabled
    // Works but is very slow
    void partTwoTest() throws IOException {
        assertEquals(553083047914L, partTwo.solution(input));
    }
}