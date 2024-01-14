package com.chrisdmilner.adventofcode.twentythree.day6;

import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DaySixTest {
    private static final PuzzleSolution partOne = new DaySixPartOne();
    private static final PuzzleSolution partTwo = new DaySixPartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(6);

    @Test
    void partOneTest() throws IOException {
        assertEquals(252000, partOne.solution(input));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(36992486, partTwo.solution(input));
    }
}