package com.chrisdmilner.adventofcode.twentythree.day21;

import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayTwentyOneTest {
    private static final PuzzleSolution partOne = new DayTwentyOnePartOne();
//    private static final PuzzleSolution partTwo = new DayTwentyOnePartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(21);
    private static final PuzzleInput exampleInput = PuzzleInputReader.getExampleInputFile(21);

    @Test
    void partOneTest() throws IOException {
        assertEquals(3562, partOne.solution(input));
    }

    @Test
    void partOneExampleTest() throws IOException {
        // Not sure if this actually correct as the problem description doesn't state the answer
        assertEquals(42, partOne.solution(exampleInput));
    }

//    @Test
//    void partTwoTest() throws IOException {
//        assertEquals(-1, partTwo.solution(input));
//    }
}