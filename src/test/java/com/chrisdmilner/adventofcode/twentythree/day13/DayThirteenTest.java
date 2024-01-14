package com.chrisdmilner.adventofcode.twentythree.day13;

import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayThirteenTest {
    private static final PuzzleSolution partOne = new DayThirteenPartOne();
    private static final PuzzleSolution partTwo = new DayThirteenPartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(13);
    private static final PuzzleInput exampleInput = PuzzleInputReader.getExampleInputFile(13);

    @Test
    void partOneTest() throws IOException {
        assertEquals(30518, partOne.solution(input));
    }

    @Test
    void partOneExampleTest() throws IOException {
        assertEquals(405, partOne.solution(exampleInput));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(36735, partTwo.solution(input));
    }

    @Test
    void partTwoExampleTest() throws IOException {
        assertEquals(400, partTwo.solution(exampleInput));
    }
}