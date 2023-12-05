package com.chrisdmilner.adventofcode.twentythree.day4;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayFourTest {
    @Test
    void partOneTest() throws IOException {
        assertEquals(26443, new DayFourPartOne().solution(PuzzleInputReader.getInputFile(4)));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(6284877, new DayFourPartTwo().solution(PuzzleInputReader.getInputFile(4)));
    }
}