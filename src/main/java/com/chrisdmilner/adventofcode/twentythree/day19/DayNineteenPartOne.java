package com.chrisdmilner.adventofcode.twentythree.day19;

import java.util.List;

public class DayNineteenPartOne extends DayNineteen {
    @Override
    long getSolution(Workflows workflows, List<Part> parts) {
        return parts.stream()
                .filter(workflows::shouldAccept)
                .mapToInt(Part::totalRating)
                .sum();
    }
}
