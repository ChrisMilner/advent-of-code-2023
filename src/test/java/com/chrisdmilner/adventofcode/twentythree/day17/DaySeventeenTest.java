package com.chrisdmilner.adventofcode.twentythree.day17;

import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInput;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleInputReader;
import com.chrisdmilner.adventofcode.twentythree.common.PuzzleSolution;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DaySeventeenTest {
    private static final PuzzleSolution partOne = new DaySeventeenPartOne();
//    private static final PuzzleSolution partTwo = new DaySeventeenPartTwo();

    private static final PuzzleInput input = PuzzleInputReader.getInputFile(17);
    private static final PuzzleInput exampleInput = PuzzleInputReader.getExampleInputFile(17);

    @Test
    void partOneTest() throws IOException {
        assertEquals(1128, partOne.solution(input));
    }

    @Test
    void partOneExampleTest() throws IOException {
        assertEquals(102, partOne.solution(exampleInput));
    }

//    @Test
//    void partTwoTest() throws IOException {
//        assertEquals(7759, partTwo.solution(input));
//    }
}