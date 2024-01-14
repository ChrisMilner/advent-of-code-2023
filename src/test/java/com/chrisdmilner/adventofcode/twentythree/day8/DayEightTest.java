package com.chrisdmilner.adventofcode.twentythree.day8;

import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayEightTest {
    private static final PuzzleSolution partOne = new DayEightPartOne();
    private static final PuzzleSolution partTwo = new DayEightPartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(8);
    private static final PuzzleInput exampleInput = PuzzleInputReader.getExampleInputFile(8);

    @Test
    void partOneTest() throws IOException {
        assertEquals(21389, partOne.solution(input));
    }

//    @Test
//    void partTwoTest() throws IOException {
//        assertEquals(0, partTwo.solution(input));
//    }

    @Test
    void partTwoExampleTest() throws IOException {
        assertEquals(6, partTwo.solution(exampleInput));
    }
}