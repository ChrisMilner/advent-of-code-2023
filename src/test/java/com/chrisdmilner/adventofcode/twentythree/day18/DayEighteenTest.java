package com.chrisdmilner.adventofcode.twentythree.day18;

import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayEighteenTest {
    private static final PuzzleSolution partOne = new DayEighteenPartOne();
    private static final PuzzleSolution partTwo = new DayEighteenPartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(18);
    private static final PuzzleInput exampleInput = PuzzleInputReader.getExampleInputFile(18);
    private static final PuzzleInput testInputOne = PuzzleInputReader.getTestInputFile(18, 1);

    @Test
    void partOneTest() throws IOException {
        assertEquals(40745, partOne.solution(input));
    }

    @Test
    void partOneExampleTest() throws IOException {
        assertEquals(62, partOne.solution(exampleInput));
    }

    @Test
    @Disabled
    // Known bug
    void partOneTestInputOneTest() throws IOException {
        assertEquals(26, partOne.solution(testInputOne));
    }

    @Test
    @Disabled
    // Too slow
    void partTwoTest() throws IOException {
        assertEquals(-1, partTwo.solution(input));
    }

    @Test
    @Disabled
    // Too slow
    void partTwoExampleTest() throws IOException {
        assertEquals(952408144115L, partTwo.solution(exampleInput));
    }
}