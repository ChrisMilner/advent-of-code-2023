package com.chrisdmilner.adventofcode.twentythree.day5;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayFiveTest {
    @Test
    void partOneTest() throws IOException {
        assertEquals(240320250, new DayFivePartOne().solution(false));
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(6284877, new DayFivePartTwo().solution(false));
    }

    @Test
    void testInputPartOneTest() throws IOException {
        assertEquals(35, new DayFivePartOne().solution(true));
    }

    @Test
    void testInputPartTwoTest() throws IOException {
        assertEquals(46, new DayFivePartTwo().solution(true));
    }
}