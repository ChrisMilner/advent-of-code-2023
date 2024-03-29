package com.chrisdmilner.adventofcode.twentythree.day10;

import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayTenTest {
    private static final PuzzleSolution partOne = new DayTenPartOne();
    private static final PuzzleSolution partTwo = new DayTenPartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(10);
    private static final PuzzleInput exampleInput = PuzzleInputReader.getExampleInputFile(10);

    @Test
    void partOneTest() throws IOException {
        assertEquals(6690, partOne.solution(input));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(525, partTwo.solution(input));
    }

    @Test
    void partOneExampleTest() throws IOException {
        assertEquals(4, partOne.solution(exampleInput));
    }

    @Test
    void partTwoExampleTest() throws IOException {
        assertEquals(1, partTwo.solution(exampleInput));
    }
}