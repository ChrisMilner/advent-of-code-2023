package com.chrisdmilner.adventofcode.twentythree.day23;

import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayTwentyThreeTest {
    private static final PuzzleSolution partOne = new DayTwentyThreePartOne();
//    private static final PuzzleSolution partTwo = new DayTwentyThreePartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(23);
    private static final PuzzleInput exampleInput = PuzzleInputReader.getExampleInputFile(23);

    @Test
    void partOneTest() throws IOException {
        assertEquals(2294, partOne.solution(input));
    }

    @Test
    void partOneExampleTest() throws IOException {
        assertEquals(94, partOne.solution(exampleInput));
    }

//    @Test
//    void partTwoTest() throws IOException {
//        assertEquals(-1, partTwo.solution(input));
//    }
}