package com.chrisdmilner.adventofcode.twentythree.day14;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayFourteenTest {
    private static final PuzzleSolution partOne = new DayFourteenPartOne();
//    private static final PuzzleSolution partTwo = new DayFourteenPartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(14);
//    private static final PuzzleInput exampleInput = PuzzleInputReader.getExampleInputFile(14);

    @Test
    void partOneTest() throws IOException {
        assertEquals(110677, partOne.solution(input));
    }

//    @Test
//    void partTwoTest() throws IOException {
//        assertEquals(36735, partTwo.solution(input));
//    }
}