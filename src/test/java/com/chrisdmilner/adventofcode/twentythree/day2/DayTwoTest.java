package com.chrisdmilner.adventofcode.twentythree.day2;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayTwoTest {
    @Test
    void partOneTest() throws IOException {
        assertEquals(2439, new DayTwoPartOne().solution(PuzzleInputReader.getInputFile(2)));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(63711, new DayTwoPartTwo().solution(PuzzleInputReader.getInputFile(2)));
    }
}
