package com.chrisdmilner.adventofcode.twentythree.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class DayOneTest {
    @Test
    void partOneTest() throws IOException {
        assertEquals(54331, new DayOnePartOne().solution());
    }

    @Test
    void partTwoTest() throws IOException {
        assertEquals(54518, new DayOnePartTwo().solution());
    }
}