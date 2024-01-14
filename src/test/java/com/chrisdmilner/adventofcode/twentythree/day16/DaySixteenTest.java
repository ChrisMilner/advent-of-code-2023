package com.chrisdmilner.adventofcode.twentythree.day16;

import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DaySixteenTest {
    private static final PuzzleSolution partOne = new DaySixteenPartOne();
    private static final PuzzleSolution partTwo = new DaySixteenPartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(16);

    @Test
    void partOneTest() throws IOException {
        assertEquals(7034, partOne.solution(input));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(7759, partTwo.solution(input));
    }
}