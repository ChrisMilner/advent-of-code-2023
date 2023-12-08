package com.chrisdmilner.adventofcode.twentythree.day5;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayFiveTest {
    private static final PuzzleSolution partOne = new DayFivePartOne();
    private static final PuzzleSolution partTwo = new DayFivePartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(5);
    private static final PuzzleInput exampleInput = PuzzleInputReader.getExampleInputFile(5);

    @Test
    void partOneTest() throws IOException {
        assertEquals(240320250, partOne.solution(input));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(28580589, partTwo.solution(input));
    }

    @Test
    void partOneExampleTest() throws IOException {
        assertEquals(35, partOne.solution(exampleInput));
    }

    @Test
    void partTwoExampleTest() throws IOException {
        assertEquals(46, partTwo.solution(exampleInput));
    }
}