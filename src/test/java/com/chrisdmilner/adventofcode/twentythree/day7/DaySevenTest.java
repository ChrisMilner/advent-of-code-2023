package com.chrisdmilner.adventofcode.twentythree.day7;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.day6.DaySixPartOne;
import com.chrisdmilner.adventofcode.twentythree.day6.DaySixPartTwo;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DaySevenTest {
    @Test
    void partOneTest() throws IOException {
        assertEquals(248812215, new DaySevenPartOne().solution(PuzzleInputReader.getInputFile(7)));
    }

//    @Test
//    void partTwoTest() throws IOException {
//        assertEquals(36992486, new DaySixPartTwo().solution(PuzzleInputReader.getInputFile(6)));
//    }
}