package com.chrisdmilner.adventofcode.twentythree.day8;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.day7.DaySevenPartOne;
import com.chrisdmilner.adventofcode.twentythree.day7.DaySevenPartTwo;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayEightTest {
    @Test
    void partOneTest() throws IOException {
        assertEquals(21389, new DayEightPartOne().solution(PuzzleInputReader.getInputFile(8)));
    }

//    @Test
//    void partTwoTest() throws IOException {
//        assertEquals(0, new DayEightPartTwo().solution(PuzzleInputReader.getInputFile(8)));
//    }
}