package com.chrisdmilner.adventofcode.twentythree.day1;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOneTest {
    private static final PuzzleSolution partOne = new DayOnePartOne();
    private static final PuzzleSolution partTwo = new DayOnePartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(1);

    @Test
    void partOneTest() throws IOException {
        assertEquals(54331, partOne.solution(input));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(54518, partTwo.solution(input));
    }
}