package com.chrisdmilner.adventofcode.twentythree.day11;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;
import com.chrisdmilner.adventofcode.twentythree.day10.DayTenPartOne;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayElevenTest {
    private static final PuzzleSolution partOne = new DayElevenPartOne();
//    private static final PuzzleSolution partTwo = new DayElevenPartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(11);
//    private static final PuzzleInput exampleInput = PuzzleInputReader.getExampleInputFile(11);

    @Test
    void partOneTest() throws IOException {
        assertEquals(10154062, partOne.solution(input));
    }

//    @Test
//    void partTwoTest() throws IOException {
//        assertEquals(0, partTwo.solution(input));
//    }

//    @Test
//    void partOneExampleTest() throws IOException {
//        assertEquals(4, partOne.solution(exampleInput));
//    }
}