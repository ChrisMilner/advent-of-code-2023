package com.chrisdmilner.adventofcode.twentythree.day3;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayThreeTest {
    private static final PuzzleSolution partOne = new DayThreePartOne();
    private static final PuzzleSolution partTwo = new DayThreePartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(3);

    @Test
    void partOneTest() throws IOException {
        assertEquals(535351, partOne.solution(input));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(87287096, partTwo.solution(input));
    }
}