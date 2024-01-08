package com.chrisdmilner.adventofcode.twentythree.day15;

import java.util.List;

public class DayFifteenPartOne extends DayFifteen {
    @Override
    long getSolution(List<String> instructions) {
        return instructions.stream()
                .mapToInt(this::hash)
                .sum();
    }
}
