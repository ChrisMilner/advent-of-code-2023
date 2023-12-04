package com.chrisdmilner.adventofcode.twentythree.day3;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DayThreeTest {
    @Test
    void partOneTest() throws IOException {
        assertEquals(535351, new DayThreePartOne().solution());
    }
}