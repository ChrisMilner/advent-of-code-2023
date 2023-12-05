package com.chrisdmilner.adventofcode.twentythree.day1;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOneTest {
    @Test
    void partOneTest() throws IOException {
        assertEquals(54331, new DayOnePartOne().solution(PuzzleInputReader.getInputFile(1)));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(54518, new DayOnePartTwo().solution(PuzzleInputReader.getInputFile(1)));
    }
}