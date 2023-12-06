package com.chrisdmilner.adventofcode.twentythree.day6;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DaySixTest {
    @Test
    void partOneTest() throws IOException {
        assertEquals(252000, new DaySixPartOne().solution(PuzzleInputReader.getInputFile(6)));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(36992486, new DaySixPartTwo().solution(PuzzleInputReader.getInputFile(6)));
    }
}