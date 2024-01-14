package com.chrisdmilner.adventofcode.twentythree.day19;

import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.framework.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayNineteenTest {
    private static final PuzzleSolution partOne = new DayNineteenPartOne();
//    private static final PuzzleSolution partTwo = new DayNineteenPartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(19);
    private static final PuzzleInput exampleInput = PuzzleInputReader.getExampleInputFile(19);

    @Test
    void partOneTest() throws IOException {
        assertEquals(432427, partOne.solution(input));
    }

    @Test
    void partOneExampleTest() throws IOException {
        assertEquals(19114, partOne.solution(exampleInput));
    }

//    @Test
//    void partTwoTest() throws IOException {
//        assertEquals(-1, partTwo.solution(input));
//    }
//
//    @Test
//    void partTwoExampleTest() throws IOException {
//        assertEquals(-1, partTwo.solution(exampleInput));
//    }
}