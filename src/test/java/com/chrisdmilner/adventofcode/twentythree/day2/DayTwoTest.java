package com.chrisdmilner.adventofcode.twentythree.day2;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayTwoTest {
    private static final PuzzleSolution partOne = new DayTwoPartOne();
    private static final PuzzleSolution partTwo = new DayTwoPartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(2);

    @Test
    void partOneTest() throws IOException {
        assertEquals(2439, partOne.solution(input));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(63711, partTwo.solution(input));
    }
}
