package com.chrisdmilner.adventofcode.twentythree.day4;

import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayFourTest {
    private static final PuzzleSolution partOne = new DayFourPartOne();
    private static final PuzzleSolution partTwo = new DayFourPartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(4);

    @Test
    void partOneTest() throws IOException {
        assertEquals(26443, partOne.solution(input));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(6284877, partTwo.solution(input));
    }
}