package com.chrisdmilner.adventofcode.twentythree.day5;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayFiveTest {
    @Test
    void partOneTest() throws IOException {
        assertEquals(240320250, new DayFivePartOne().solution(PuzzleInputReader.getInputFile(5)));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(28580589, new DayFivePartTwo().solution(PuzzleInputReader.getInputFile(5)));
    }

    @Test
    void testInputPartOneTest() throws IOException {
        assertEquals(35, new DayFivePartOne().solution(PuzzleInputReader.getTestInputFile(5)));
    }

    @Test
    void testInputPartTwoTest() throws IOException {
        assertEquals(46, new DayFivePartTwo().solution(PuzzleInputReader.getTestInputFile(5)));
    }
}