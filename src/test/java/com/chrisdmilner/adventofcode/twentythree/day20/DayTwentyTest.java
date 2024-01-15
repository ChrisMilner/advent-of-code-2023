package com.chrisdmilner.adventofcode.twentythree.day20;

import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayTwentyTest {
    private static final PuzzleSolution partOne = new DayTwentyPartOne();
//    private static final PuzzleSolution partTwo = new DayTwentyPartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(20);
    private static final PuzzleInput exampleInput = PuzzleInputReader.getExampleInputFile(20);

    @Test
    void partOneTest() throws IOException {
        assertEquals(-1, partOne.solution(input));
    }

    @Test
    void partOneExampleTest() throws IOException {
        assertEquals(11687500, partOne.solution(exampleInput));
    }

//    @Test
//    void partTwoTest() throws IOException {
//        assertEquals(-1, partTwo.solution(input));
//    }

//    @Test
//    void partTwoExampleTest() throws IOException {
//        assertEquals(-1, partTwo.solution(exampleInput));
//    }
}