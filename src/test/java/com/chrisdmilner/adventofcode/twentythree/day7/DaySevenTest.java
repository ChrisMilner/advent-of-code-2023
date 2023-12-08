package com.chrisdmilner.adventofcode.twentythree.day7;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DaySevenTest {
    @Test
    void partOneTest() throws IOException {
        assertEquals(248812215, new DaySevenPartOne().solution(PuzzleInputReader.getInputFile(7)));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(0, new DaySevenPartTwo().solution(PuzzleInputReader.getInputFile(7)));
    }
}