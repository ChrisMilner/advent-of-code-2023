package com.chrisdmilner.adventofcode.twentythree.day7;

import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DaySevenTest {
    private static final PuzzleSolution partOne = new DaySevenPartOne();
    private static final PuzzleSolution partTwo = new DaySevenPartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(7);

    @Test
    void partOneTest() throws IOException {
        assertEquals(248812215, partOne.solution(input));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(250057090, partTwo.solution(input));
    }
}